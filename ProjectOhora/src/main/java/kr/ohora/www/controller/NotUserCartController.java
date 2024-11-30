package kr.ohora.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class NotUserCartController {
	
	@GetMapping("/notusercart.htm")
	public String home() {
		log.info("컨트롤러 들어옴!~!!!");
		
		return "cart.notusercart";
	}
	@PostMapping("/notusercart.htm")
	public String asdf() {
	return null;
	}
	
}
