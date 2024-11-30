package kr.ohora.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ohora.www.domain.UserDTO;
import kr.ohora.www.domain.product.ProductDTO;
import kr.ohora.www.domain.security.CustomerUser;
import kr.ohora.www.service.OrderService;
import lombok.extern.log4j.Log4j;
@Log4j
@Controller
public class OrderController {
	@Autowired
	   private OrderService OrderService;
	   
	   @GetMapping("/order/Order")
	   public String Order(
			   @RequestParam(required = false) String[] pdtId,
		       @RequestParam(required = false) String[] pdtCount,
		       @AuthenticationPrincipal CustomerUser customUser,
		       Model model) {
		       
		       System.out.println("OrderController...");
		       
		       // Principal에서 userId 가져오기
		       Integer userId = 0;
		       if(customUser != null) {
		           userId = customUser.getUser().getUserId();
		       }
		       log.info("userId : " + userId);
		       
		       if (pdtId == null || pdtCount == null) {
		           return "redirect:/ohora/main";
		       }
		       
		       // 수량 배열 변환
		       int[] pdtCountArray = new int[pdtCount.length];
		       for (int i = 0; i < pdtCount.length; i++) {
		           pdtCountArray[i] = Integer.parseInt(pdtCount[i]);
		       }
		       
		       try {
		           // 회원 정보 조회
		           if (userId != 0) {
		               UserDTO userDTO = OrderService.getUserInfo(userId);
		               List<AddrDTO> addrList = OrderService.getAddrList(userId);
		               List<CouponDTO> couponList = OrderService.getCouponList(userId);
		               
		               String email = userDTO.getUserEmail();
		               String[] telArr = userDTO.getUserTel() != null ? 
		                   userDTO.getUserTel().split("-") : new String[]{"", "", ""};
		                   
		               model.addAttribute("userDTO", userDTO);
		               model.addAttribute("addrList", addrList);
		               model.addAttribute("couponList", couponList);
		               model.addAttribute("emailArr", email);
		               model.addAttribute("telArr", telArr);
		           }
		           
		           // 상품 정보 조회 
		           if (pdtId != null) {
		               List<ProductDTO> pdtList = OrderService.getProductList(pdtId);
		               model.addAttribute("pdtList", pdtList);
		           }
		           
		           model.addAttribute("pdtCountArray", pdtCountArray);
		           
		       } catch (Exception e) {
		           e.printStackTrace();
		       }
		       
		       return "order.order";
	   }
}
