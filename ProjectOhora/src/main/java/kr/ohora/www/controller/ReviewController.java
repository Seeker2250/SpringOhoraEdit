package kr.ohora.www.controller;

import java.io.File; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kr.ohora.www.domain.review.RevMedia;
import kr.ohora.www.domain.review.ReviewDTO;
import kr.ohora.www.domain.review.ReviewRating;
import kr.ohora.www.domain.review.WritingReviewDTO;
import kr.ohora.www.persistence.ReviewMapper;
import kr.ohora.www.service.ReviewService;
import lombok.extern.log4j.Log4j;
 
@Controller
@Log4j
public class ReviewController {

	@Autowired
	private ReviewService reviewService; 

	@GetMapping(value="/reviewTEST.htm")
	public String test() {
		log.info("컨트롤러 들어옴><:><>><>><><><><><><><>");
		return "review.reviewTEST";
	}

	@GetMapping(value="/review.htm")
	public String list
	(
			Model model , 
			@RequestParam(value = "pdt_id", defaultValue = "1") int pdt_id ,
			@RequestParam(value = "sort", defaultValue = "recommend") String sort

			) throws SQLException {
		log.info("리뷰 컨트롤러 들어옴><:><>><>><><><><><><><>");
		log.info(pdt_id +"//////" + sort);

		model.addAttribute( "list", this.reviewService.list(pdt_id, sort) );
		model.addAttribute( "mediaCnt", this.reviewService.midiaCount(pdt_id) );
		model.addAttribute( "photos", this.reviewService.selectPhotos(pdt_id) );
		model.addAttribute( "rating", this.reviewService.ratingAVG(pdt_id) );

		return "reviewList.oho_review";
	}

	@GetMapping(value="/reviewPop/{opdtId}/{ordPk}.htm")
	public String writeTest(@PathVariable("opdtId") int opdtId, @PathVariable("ordPk") int ordPk ,Model model) {
		System.out.println(opdtId);
		System.out.println(ordPk);

		model.addAttribute("opdtId", opdtId);
		model.addAttribute("ordPk", ordPk);
		//주문 상세 번호임

		log.info("리뷰작성진입 컨트롤러");
		return "reviewWrite.oho_reviewWrite";
	}

	/*
	@PostMapping(value="/reviewPop/{ordNo}.htm")
	public String reviewInsert(Model model,@PathVariable("ordNo") String ordNo,@PathVariable("rvContent") String rvContent,
											@PathVariable("attach") ) {
		System.out.println(ordNo);

		//int rowCount = this.reviewService.reviewWrite(ordNo);

		log.info("리뷰작성 컨트롤러");
		return "reviewWrite.oho_reviewWrite";
	}
	 */

	@PostMapping( value="/reviewPopWrite.htm")
	public String reviewInsert(WritingReviewDTO rvm ) {
		System.out.println("리뷰 서브밋하러 들어왔다!!!!!!!!!!!!!" );
		System.out.println("RVM@#!@#!@#!@#" + rvm);
		// rvm 에는 오더디테일PK, 글내용, 이미지 파일 정보들이 있음

		this.reviewService.reviewWrite(rvm );

		return "redirect:/popupClosePage.htm";
	}



	@RequestMapping("/popupClosePage.htm")
	@ResponseBody
	public String closePopupAndAlert() {
	    return "<script type='text/javascript'>"
	            + "if (window.opener) {"  // 부모 창이 있는 경우
	            + "    window.opener.location.href = '/user/mypage.htm';"  // 부모 창 이동
	            + "    window.close();"  // 팝업 창 닫기
	            + "} else {"  // 부모 창이 없으면
	            + "    alert('부모 창이 없습니다.');"
	            + "}"
	            + "</script>";
	}


	@GetMapping("/reviewDelete/{opdtId}.htm")
	public String revDelete(@PathVariable("opdtId") int opdtId) {
		System.out.println("리뷰 삭제 진입 :: " + opdtId);

		try {
			int rowCount = this.reviewService.deleteReview(opdtId);
		    return "redirect:/user/mypage.htm";
		} catch (Exception e) {
		    System.err.println("(Controller)삭제 중 오류 발생: " + e.getMessage());
		    throw e;
		}
	}
	

}//class
