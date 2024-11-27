package kr.ohora.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class NotUserCartController {
	
	@GetMapping("/notusercart.htm")
	public String home() {
		log.info("컨트롤러 들어옴!~!!!");
		
		return "notusercart.notusercart";
	}
}
