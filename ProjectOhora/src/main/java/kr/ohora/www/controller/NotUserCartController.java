package kr.ohora.www.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import kr.ohora.www.domain.product.ProductDTO;
import kr.ohora.www.service.NotUserCartService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class NotUserCartController {
	
	@Autowired
	NotUserCartService notUserCartService;
	
	@GetMapping("/notusercart.htm")
	public String notUserCart(
			Model model,
			HttpServletRequest request,
			//basketItems
	        @CookieValue(value =  "basketItems", required = false) String basketItems) throws UnsupportedEncodingException {
			log.info("컨트롤러 들어옴!~!!!");
			model.addAttribute("cookie",  basketItems);
			
			//CookieValue
			System.out.println("쿠키값@@@@@@@@@"+basketItems);
	        System.out.println("==== 쿠키 디버깅 종료 ====");
	        
	        
	        // request로 받은 쿠키들 확인
	        Cookie[] cookies = request.getCookies();
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                System.out.println("쿠키이름: " + cookie.getName() + ", 값: " + cookie.getValue());
	            }
	        } else {
	            System.out.println("request.getCookies(): null");
	        }
	        
	        System.out.println("==== 쿠키 디버깅 종료 ====");
	        
	        List<Integer> productIds = new ArrayList<>();
	        List<Integer> quantities = new ArrayList<>();
	        // basketItems가 null이 아니고 비어있지 않을 때만 처리
	        if (basketItems != null && !basketItems.isEmpty()) {
	            // "/"로 각 상품 정보를 분리
	            String[] items = basketItems.split("/");
	            
	            for (String item : items) {
	                // ":"로 상품ID와 수량을 분리
	                String[] parts = item.split(":");
	                if (parts.length == 2) {
	                    try {
	                        int productId = Integer.parseInt(parts[0]);
	                        int quantity = Integer.parseInt(parts[1]);
	                        
	                        productIds.add(productId);
	                        quantities.add(quantity);
	                    } catch (NumberFormatException e) {
	                        log.error("상품 정보 파싱하다가 멘탈 터짐~~: " + item, e);
	                    }
	                }
	            }
	        }
	        
	        // 디버깅용이야~~~~
	        log.info("상품 ID 리스트: " + productIds);
	        log.info("수량 리스트: " + quantities);
	        

	     // 상품 정보 조회
	        List<ProductDTO> products = notUserCartService.getProductsByIds(productIds);
	        
	        // Model에 데이터 추가
	        model.addAttribute("products", products);
	        model.addAttribute("quantities", quantities);
	        model.addAttribute("cookie", basketItems);
	        
	        
	        
		 return "notusercart.notusercart";
	}
	
}
