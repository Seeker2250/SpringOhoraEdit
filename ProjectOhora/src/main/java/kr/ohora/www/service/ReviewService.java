package kr.ohora.www.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kr.ohora.www.domain.review.CommentDTO;
import kr.ohora.www.domain.review.RevMedia;
import kr.ohora.www.domain.review.ReviewDTO;
import kr.ohora.www.domain.review.ReviewRating;
import kr.ohora.www.domain.review.WritingReviewDTO;
import kr.ohora.www.persistence.ReviewMapper; 

public interface ReviewService {

	//처음 리뷰 뿌리기
	ArrayList<ReviewDTO>  list( int pdt_id , String sort ) throws SQLException;
	
	//전체 미디어 리뷰의 숫자
	Integer midiaCount( int pdt_id) throws SQLException;
	
	//리뷰마다 사진 뿌리기
	ArrayList<RevMedia> selectPhotos(int pdt_id) throws SQLException;
	
	//별점 평균 및 그래프
	ReviewRating ratingAVG( int pdt_id) throws SQLException;
	
	//댓글 불러오기
     List<CommentDTO> cmtSelect(int revId) throws SQLException;
	
 	//댓글 작성하기
	void insertCommentAndCntUp( int revId, int userId, String comment, Date writedate) throws SQLException;
    
	//댓글 작성 완료 - 바로 불러오기
    List<CommentDTO> cmtBaroSelect(int revId) throws SQLException;

    //댓글 삭제
	int deleteCommentAndCntUp(int cmtId, int revId) throws SQLException;

	//리뷰 더보기
	List<ReviewDTO> moreReviews(@Param("pdtId") int pdtId, @Param("currentRevPage") int currentRevPage , @Param("sort") String sort ) throws SQLException;

	//전체 리뷰 수 가져오기
	int allRevCnt(int pdtId) throws SQLException;

	//리뷰작성
	int reviewWrite(WritingReviewDTO rvm);

	//리뷰 삭제
	int deleteReview(int opdtId);

	
}







