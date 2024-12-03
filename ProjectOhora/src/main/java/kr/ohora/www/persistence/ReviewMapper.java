package kr.ohora.www.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kr.ohora.www.domain.review.CommentDTO;
//import net.sf.json.JSONObject;
import kr.ohora.www.domain.review.RevMedia;
import kr.ohora.www.domain.review.ReviewDTO;
import kr.ohora.www.domain.review.ReviewRating;
import kr.ohora.www.domain.review.WritingReviewDTO;

public interface ReviewMapper {

	//리뷰 뿌리기
	ArrayList<ReviewDTO> select(@Param("pdt_id") int pdt_id, @Param("sort") String sort) throws SQLException;

	//리뷰 전체 미디어 받아오기
	Integer midiaCount( int pdt_id) throws SQLException;

	//리뷰마다 미디어 뿌리기
	ArrayList<RevMedia> selectPhotos(int pdt_id) throws SQLException;

	//별점 그래프 및 평균
	ReviewRating ratingAVG( int pdt_id) throws SQLException;

	// 리뷰 댓글 작성
	int insertComment(@Param("revId") int revId, @Param("userId") int userId, @Param("comment") String comment, @Param("writedate") Date writedate) throws SQLException;

	// 리뷰 댓글 숫자 업
	int cmtUp(int revId) throws SQLException;

	//리뷰 댓글 보기  
	List<CommentDTO> cmtSelect (@Param("revId") int rev_id) throws SQLException;

	//리뷰 댓글 삭제
	int deleteComment(int cmtId);

	//리뷰 댓글 숫자 다운
	int cmtDown(int revId);

	//리뷰 더보기
	List<ReviewDTO> selectMoreReview(@Param("pdtId") int pdtId, @Param("currentRevPage") int currentRevPage,@Param("sort") String sort) throws SQLException;

	//리뷰 번호로 사진들 찾기
	ArrayList<RevMedia> selectPhotosByRevId(int revId);

	//전체 리뷰 갯수
	Integer getTotalRevCnt(int pdtId);

	//리뷰 작성
	int reviewWrite(WritingReviewDTO rvm);
	
	//리뷰 이미지 DB 이름 저장
	int reviewImgUpload(String filePath);

	//리뷰 삭제
	int deleteReview(int opdtId);

	//리뷰 이미지 삭제
	int deleteReviewUrl(int opdtId);

	//리뷰 댓글 삭제
	int deleteReviewComment(int opdtId);

	//리뷰 삭제 시 삭제할 파일명들 가져오기
	List<String> selectDelFiles(int opdtId);

	//리뷰 삭제시 카운트 -1
	int deleteReviewCount(int opdtId);
	
	//리뷰 작성시 카운트 +1
	void productRevUp(WritingReviewDTO rvm);

	

	
	
	
	
}
