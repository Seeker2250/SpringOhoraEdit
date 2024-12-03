package kr.ohora.www.service;

import java.io.File;
import java.net.http.HttpRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kr.ohora.www.domain.review.CommentDTO;
import kr.ohora.www.domain.review.RevMedia;
import kr.ohora.www.domain.review.ReviewDTO;
import kr.ohora.www.domain.review.ReviewRating;
import kr.ohora.www.domain.review.WritingReviewDTO;
import kr.ohora.www.persistence.ReviewMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService{


	@Autowired
	private ReviewMapper reviewMapper;


	@Override
	public ArrayList<ReviewDTO> list(int pdt_id, String sort) throws SQLException {

		ArrayList<ReviewDTO> list = this.reviewMapper.select(pdt_id, sort);
		System.out.println("========list 출력!!=========");
		System.out.println(list);

		return list;
	}

	@Override
	public Integer midiaCount(int pdt_id) throws SQLException {
		Integer mediaCnt =  this.reviewMapper.midiaCount(pdt_id);
		System.out.println("========mediaCnt 출력!!=========");
		System.out.println(mediaCnt);
		return mediaCnt;
	}

	@Override
	public ArrayList<RevMedia> selectPhotos(int pdt_id) throws SQLException {

		ArrayList<RevMedia> photos = this.reviewMapper.selectPhotos( pdt_id);
		System.out.println("========photos 출력!!=========");
		System.out.println(photos);

		return photos;
	}

	@Override
	public ReviewRating ratingAVG(int pdt_id) throws SQLException {
		ReviewRating rating = this.reviewMapper.ratingAVG( pdt_id);
		System.out.println("========rating 출력!!=========");
		System.out.println(rating);

		return rating;
	}

	@Override
	public  List<CommentDTO>  cmtSelect(int revId) throws SQLException {
		List<CommentDTO> comments = this.reviewMapper.cmtSelect(revId);
		System.out.println("========COMMENTS 출력!!=========");
		System.out.println(comments);

		return comments;
	}

	@Override
	@Transactional
	public void insertCommentAndCntUp( int revId, int userId , String comment, Date writedate) throws SQLException {

		int cmtIn = this.reviewMapper.insertComment(revId,userId,comment,writedate);

		int cntUp = this.reviewMapper.cmtUp(revId);

	}

	@Override
	public List<CommentDTO> cmtBaroSelect(int revId) throws SQLException {
		List<CommentDTO> comments = this.reviewMapper.cmtSelect(revId);
		return comments;
	}

	@Override
	@Transactional
	public int deleteCommentAndCntUp(int cmtId, int revId) {

		int cmtDel = this.reviewMapper.deleteComment(cmtId);
		System.out.println("zzzzzzzz"  + cmtDel);
		int cntDown = this.reviewMapper.cmtDown(revId);
		System.out.println("zzzzzzzxxxz" + cntDown);

		return cmtDel + cntDown;
	}

	@Override
	public List<ReviewDTO> moreReviews(int pdtId, int currentRevPage , String sort) throws SQLException {
		System.out.println("PDT_ID@#@ 처음 넘어온애들 PDTID:::"  + pdtId + " CURR/" + currentRevPage + " SORT/" + sort);
		List<ReviewDTO> moreRev = this.reviewMapper.selectMoreReview(pdtId, currentRevPage, sort);


		for (ReviewDTO revAndPhotos : moreRev) {
			ArrayList<RevMedia> photos = reviewMapper.selectPhotosByRevId(revAndPhotos.getRevId());
			revAndPhotos.setRevMediaList(photos);
		}

		System.out.println(">>>>>리뷰 사진 추가됨?? >>>> " + moreRev);


		return moreRev;
	}

	@Override
	public int allRevCnt(int pdtId) throws SQLException {
		//전체 리뷰수 셀렉트
		return this.reviewMapper.getTotalRevCnt(pdtId);
	}

	@Override
	@Transactional
	public int reviewWrite(WritingReviewDTO rvm) {
		
	   String path = "ProjectOhora";
		//경로 직접 써줘야함..
	   String uploadFolder = "C:\\Users\\User1\\Desktop\\1201\\SpringOhora\\ProjectOhora\\src\\main\\webapp\\reviewMedia";  // 업로드 폴더 경로
		System.out.println("$$$uploadFolder:::::::::::" + uploadFolder);
		List<CommonsMultipartFile> attachList = rvm.getAttach();
		List<String> savedFilePath = new ArrayList<String>(); // DB에 넣을 시스템경로임
		
		for (CommonsMultipartFile attach : attachList) {

			if ( ! attach.isEmpty()) {	
				// 1. 첨부된 파일의 정보 출력
				log.info("-".repeat(30));
				log.info("2. originalFilename : " + attach.getOriginalFilename());
				log.info("2. size : " + attach.getSize());          
				// 2. 첨부파일 저장
				String originalFilename = attach.getOriginalFilename(); 
				String filesystemName = getFileNameCheck(uploadFolder, originalFilename);
				log.info("3. SystemFilename : " + filesystemName);
				File saveFile = new File(uploadFolder,filesystemName );
				savedFilePath.add(filesystemName); //경로들도 리스트에 저장..
				
				try {
					attach.transferTo(saveFile); //저장
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}//if

		}//foreach


		// o_review 테이블에 들어갈 정보들
		int rowCount1=this.reviewMapper.reviewWrite(rvm);
		int rowCount2 = 0;
		
		//제품의 리뷰 수 업데이트
		this.reviewMapper.productRevUp(rvm);
		
		for (String FilePath : savedFilePath) {
			// o_revurl에 들어갈 이미지 파일 경로
			rowCount2 = this.reviewMapper.reviewImgUpload(FilePath);
		}
		
		
		return rowCount1 + rowCount2;
	}



	//파일 중복이름 체크
	private String getFileNameCheck(String uploadRealPath, String originalFilename) {
		int index = 1;      
		while( true ) {         
			File f = new File(uploadRealPath, originalFilename);         
			if( !f.exists() ) return originalFilename;         
			// upload 폴더에 originalFilename 파일이 존재한다는 의미       
			String fileName = originalFilename.substring(0, originalFilename.lastIndexOf("."));  //   a
			String ext = originalFilename.substring(originalFilename.lastIndexOf("."));  // .txt
			// asdfasf-3.txt
			originalFilename = fileName+"-"+(index)+ext;

			index++;
		} // while 
	}

	@Override
	@Transactional
	public int deleteReview(int opdtId) {
		try {
			List<String> delFiles = this.reviewMapper.selectDelFiles(opdtId);
			System.out.println("삭제할 파일 배열::::::::::" +delFiles);
			// 실제 파일 삭제 작업
			
			//경로 직접 써줘야함..
			String uploadRealPath = "C:\\Users\\User1\\Desktop\\1201\\SpringOhora\\ProjectOhora\\src\\main\\webapp\\reviewMedia";
			for (String delFile : delFiles) {
			    File deleteFile = new File(uploadRealPath, delFile);
			    if (deleteFile.exists() && deleteFile.isFile()) {
			    	deleteFile.delete();  // 파일 삭제
			        System.out.println(delFile + " 삭제됨");
			    } else {
			        System.out.println(delFile + " 파일이 존재하지 않음");
			    }
			}
			
			
		    int rowCount = this.reviewMapper.deleteReviewUrl(opdtId);
		    System.out.println("삭제된 URL 레코드 수: " + rowCount);
		    rowCount += this.reviewMapper.deleteReviewComment(opdtId);
		    System.out.println("삭제된 URL+댓글 레코드 수: " + rowCount);
		    rowCount += this.reviewMapper.deleteReview(opdtId);
		    System.out.println("삭제된 리뷰+URL 레코드 수: " + rowCount);
		    rowCount += this.reviewMapper.deleteReviewCount(opdtId);
		    System.out.println("삭제된 리뷰+URL 레코드 수: " + rowCount);

		    
		    return rowCount;
		} catch (Exception e) {
		    System.err.println("삭제 중 오류 발생: " + e.getMessage());
		    throw e;
		}
	}



}//class








