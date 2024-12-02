package kr.ohora.www.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ohora.www.domain.AddrDTO;
import kr.ohora.www.domain.UserDTO;
import kr.ohora.www.domain.order.OrderDTO;
import kr.ohora.www.domain.product.ProductDTO;
import kr.ohora.www.domain.security.CustomerUser;
import kr.ohora.www.service.order.OrderService;
import lombok.extern.log4j.Log4j;
@Controller
@Log4j
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/order/page.htm")
	   public String Order(
			   @RequestParam(required = false) int[] pdtId,
		       @RequestParam(required = false) int[] pdtCounts,
		       Principal principal,
		       Model model) {
		       System.out.println("OrderController에 /order.htm으로 일단 들어옴!!");
		       //Principal에서 userId 가져오기
		       CustomerUser customUser = (CustomerUser) ((Authentication) principal).getPrincipal();
		       log.info("userId : " + customUser.getUser().getUserId());
		       int userId = customUser.getUser().getUserId();
		    
		   
		       if (pdtId == null || pdtCounts == null) {
		           return "redirect:/ohora/main";
		       }
		   		log.info("pdtId요청!@@@@@ " + Arrays.toString(pdtId));
		   		log.info("pdtCounts요청!@@@@@ " + Arrays.toString(pdtCounts));
		   		
		   		
		      
		       try {
		           // 회원 정보 조회
		           if (userId != 0) {
		               UserDTO userDTO = orderService.getUserInfo(userId);
		               List<AddrDTO> addrList = orderService.getAddrList(userId);
		               
		             //  List<CouponDTO> couponList = OrderService.getCouponList(userId);
		               
		               String email = userDTO.getUserEmail();
		               String[] telArr = null;
		               if(userDTO.getUserTel() != null) {
		                  telArr = userDTO.getUserTel().split("-");  // ["010", "1234", "5678"]
		               } else {
		                  telArr = new String[]{"", "", ""};  // 없으면 빈 배열로 초기화
		               }
		               model.addAttribute("telArr", telArr);
		               //String tel = userDTO.getUserTel() != null ? userDTO.getUserTel() : "";
		               model.addAttribute("userDTO", userDTO);
		               model.addAttribute("addrList", addrList);
		              // model.addAttribute("couponList", couponList);
		               model.addAttribute("emailArr", email);
		               //model.addAttribute("tel", tel);
		           }
		           
		           // 상품 정보 조회 
		           if (pdtId != null) {
		               List<ProductDTO> pdtList = orderService.getProductList(pdtId);
		               model.addAttribute("pdtList", pdtList);
		           }
		           
		           model.addAttribute("pdtCounts", pdtCounts);
		           
		       } catch (Exception e) {
		           e.printStackTrace();
		       }
		       
		       return "order.member_order";
	   }
    
    
    
    @PostMapping("/order/result.htm")
    public String order(
    		OrderDTO ord,
       //String rname,//이름
	   //String rzipcode1, //우편번호
	 //  String raddr1,// 주소
	  // String raddr2,// 상세 주소
	  // String rphone2_1,//번호1
	  // String rphone2_2, //번호2
	   //String rphone2_3,//번호3
	   
	   
	   //String email1,//이메일
	   //String addrPaymethod,//결제 수단
	  // String[] pdtNames,//상품 이름
	   //int[] pdtCountsss,//상품 수량
	   //int[] pdtAmounts, //상품 원가
	   ////int[] pdtDcAmounts,//상품 할인가
	   //int[] pdtIds, //상품 아이디들
	  // int totalSum, //원가 총합
	   //int discountSum,//할인가 총합
	   //@RequestParam(value = "icpnId", required = false, defaultValue = "0") int icpnId, // 쿠폰 아이디
       //@RequestParam(value = "icpnDc", required = false, defaultValue = "0") int icpnDc, // 쿠폰 할인율
      //// @RequestParam(value = "input_point", required = false, defaultValue = "0") int inputPoint, // 적립금
       Principal principal,
       RedirectAttributes rttr) {
    	CustomerUser customUser = (CustomerUser) ((Authentication) principal).getPrincipal();
	    log.info("userId는 뭐냐면 " + customUser.getUser().getUserId());
	    int userId = customUser.getUser().getUserId();
        try {
        	
        	ord.setUserId(userId);
        	
        	//주소 합쳐서 재구성
        	 //String address = raddr1 + " " + raddr2;
        	String address = ord.getRaddr1()+ " " + ord.getRaddr2();
        	 ord.setAddress(address);
        	 //번호 합쳐서 다시 만드러
        	 //String phone = rphone2_1 + "-" + rphone2_2 + "-" + rphone2_3;
        	 String phone = ord.getRphone2_1() + "-" + ord.getRphone2_2() + "-" + ord.getRphone2_3();
        	 ord.setPhone(phone);
        	 // 배송비 계산
             int deliFee = (ord.getTotalSum() - ord.getDiscountSum() - ord.getIcpnDc()) > 50000 ? 0 : 3000;
             ord.setDeliveryFee(deliFee);
            
            String orderId = orderService.order(ord);
            
    
	      
	   	    
            //주문 시간 형식 정해놔
            LocalDateTime orderTime = LocalDateTime.now();
            String formattedTime = orderTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            
            //한 번만 쓰고 db에 넣으면 돼
            rttr.addAttribute("orderId", orderId);
            rttr.addAttribute("orderTime", formattedTime);
            
            return "redirect:/order.endorder_log";
            
        } catch (Exception e) {
            log.error("주문 처리 실패", e);
            return "redirect:/order/fail";
        }
    }
}