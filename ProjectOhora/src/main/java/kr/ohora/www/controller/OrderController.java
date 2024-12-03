package kr.ohora.www.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		       
		       return "order.oho_member_order";
	   }
    
    
    
    @PostMapping("/order/result.htm")
    public String order(
    		OrderDTO ord,
    		Principal principal,
    		Model model
    		, HttpSession session) {
    		CustomerUser customUser = (CustomerUser) ((Authentication) principal).getPrincipal();
    		log.info("userId는 뭐냐면 " + customUser.getUser().getUserId());
    		int userId = customUser.getUser().getUserId();
    		try {
        	
        	ord.setUserId(userId);
        	
        	//주소 합쳐서 재구성
        	String address = ord.getRaddr1()+ " " + ord.getRaddr2();
        	 ord.setAddress(address);
        	 
        	 //번호 합쳐서 다시 만드러
        	 String phone = ord.getRphone2_1() + "-" + ord.getRphone2_2() + "-" + ord.getRphone2_3();
        	 ord.setPhone(phone);
        	 
        	 // 배송비 계산
             int deliFee = (ord.getTotalSum() - ord.getDiscountSum() - ord.getIcpnDc()) > 50000 ? 0 : 3000;
             ord.setDeliveryFee(deliFee);
            
            String orderId = orderService.order(ord);
            
    
	      
	   	    
            //주문 시간 형식 정해놔
            LocalDateTime orderTime = LocalDateTime.now();
            String formattedTime = orderTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            
            if (ord.getProducts() != null) {
                log.info("Products 리스트 크기는@@@@@ " + ord.getProducts().size());
                for (ProductDTO product : ord.getProducts()) {
                    log.info("ProductDTO가 뭐냐면: " + product);
                }
            } else {
                log.error("Products 리스트가 null이야ㅠㅠㅠㅠㅠ");
            }
            
            model.addAttribute("orderId", orderId);
            model.addAttribute("orderTime", formattedTime);
            model.addAttribute("isSuccess", true);
            Object oldPdtCount = session.getAttribute("pdtCount");
            if (ord.getProducts() != null && !ord.getProducts().isEmpty()) {
                int productsSize = ord.getProducts().size();
                oldPdtCount = (int) oldPdtCount - productsSize;
                session.setAttribute("pdtCount", oldPdtCount);
            }
            return "order.oho_endorder_log"; 
            
        } catch (Exception e) {
        	log.error("주문 처리 실패", e);
            model.addAttribute("isSuccess", false);  // 실패 플래그 추가
            model.addAttribute("errorMessage", "주문에 실패하셨습니다. 다시 시도해주세요.");
            return "order.oho_endorder_log";
        }
    }
}