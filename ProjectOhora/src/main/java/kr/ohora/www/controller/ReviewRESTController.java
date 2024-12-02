package kr.ohora.www.controller;

import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ohora.www.domain.review.CommentDTO;
import kr.ohora.www.domain.review.ReviewDTO;
import kr.ohora.www.service.ReviewService;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/ajax/*")
public class ReviewRESTController {
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping( value =  "/reviewcommentList/{revId}.ajax" )
	public  ResponseEntity<List<CommentDTO>> getComments(@PathVariable("revId") int revId) throws SQLException {

		log.info("> AJAXAJAX : RESTRESTRESTRESTRESTRESTRESTREST@!@!@!");

		// return this.reviewService.cmtSelect(revId);
		 return new ResponseEntity<>(this.reviewService.cmtSelect(revId), HttpStatus.OK);
		 
	}
	
	
	@PostMapping( value = "/reviewcommentWriteAndcntUp.ajax" )
	public void postComment(
			@RequestParam("comment") String comment ,
			@RequestParam("userId") int userId,
			@RequestParam("revId") int revId
			) throws SQLException {
		Date writedate = new Date();
		log.info("> AJAXAJAX : 댓글작성");
		System.out.println("코멘트: " + comment + "/" + "유저 아이디" + userId + "/" + "리뷰아이디" + revId + "작성일 " + writedate);
		this.reviewService.insertCommentAndCntUp(revId, userId, comment,  writedate);

	}
	
	@GetMapping( value =  "/reviewcommentCntUpView/{revId}.ajax" )
	public  ResponseEntity<List<CommentDTO>> getBaroComments(@PathVariable("revId") int revId) throws SQLException {

		log.info("> AJAXAJAX : BAROOOORESTRESTRESTRESTRESTRESTRESTREST@!@!@!");

		// return this.reviewService.cmtSelect(revId);
		 return new ResponseEntity<>(this.reviewService.cmtBaroSelect(revId), HttpStatus.OK);
		 
	}
	
	@GetMapping(value ="/reviewcommentDelete.ajax")
	public int deleteComment(@RequestParam("cmt_id") int cmtId ,@RequestParam("revId") int revId ) throws SQLException {
		int rowCount;
		
		log.info("> AJAXAJAX : BAROOOORESTRESTRESTRESTRESTRESTRESTREST@!@!@! :::" + cmtId +"/" +revId);
		rowCount = this.reviewService.deleteCommentAndCntUp(cmtId, revId);
		
		if ( rowCount ==2 ) {
			log.info("> AJAXAJAX : REVIDREVIDREVIDREVIDREVIDREVIDREVID :::" + rowCount +"/" +revId);
			return revId;
		} else {
			rowCount= 0;
		}
		
		return rowCount;
		
	}
	
	
	  @GetMapping(value ="/reviewMore.ajax") 
	  public ResponseEntity<Map<String, Object>> selectMoreReview(
			  @RequestParam("pdtId") int pdtId ,
			  @RequestParam("sort") String sort ,
			  @RequestParam("currentRevPage") int currentRevPage ) throws SQLException
	  {
	  
	  log.info("> AJAXAJAX : MOREREVIEW@#@#@# :::" + pdtId +"/" +sort +"/"+currentRevPage);
	  
	  List<ReviewDTO> reviews =this.reviewService.moreReviews(pdtId ,currentRevPage ,sort);
	  int allRevCnt = this.reviewService.allRevCnt(pdtId);
	  
	  Map<String, Object> result = new HashMap<>();
	  result.put("reviews", reviews );
	  result.put("allRevCnt", allRevCnt );
	  
	  
	  return new ResponseEntity<>(result,HttpStatus.OK);
	  
	  }
	 
	
}//class
