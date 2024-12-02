package kr.ohora.www.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ohora.www.domain.review.RevMedia;
import kr.ohora.www.domain.review.ReviewDTO;
import kr.ohora.www.domain.review.ReviewRating;
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
	
	@GetMapping(value="/reviewPop/{ordNo}.htm")
	public String writeTest(@PathVariable("ordNo") String ordNo, Model model) {
		System.out.println(ordNo);
		
		model.addAttribute("ordNo", ordNo);
		
		log.info("리뷰작성 컨트롤러");
		return "reviewWrite.oho_reviewWrite";
	}
	
}
