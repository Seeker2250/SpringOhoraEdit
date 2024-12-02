package kr.ohora.www.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ohora.www.domain.review.CommentDTO;
import kr.ohora.www.domain.review.RevMedia;
import kr.ohora.www.domain.review.ReviewDTO;
import kr.ohora.www.domain.review.ReviewRating;
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
	public void reviewWrite(String ordNo) {
		// TODO Auto-generated method stub
		
	}


	
	

	
}//class








