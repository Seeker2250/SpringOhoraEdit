package kr.ohora.www.controller;

import java.security.Principal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ohora.www.domain.AddressDTO;
import kr.ohora.www.domain.MyPageDTO;
import kr.ohora.www.domain.OrderDetailDTO;
import kr.ohora.www.domain.UserDTO;
import kr.ohora.www.domain.security.CustomerUser;
import kr.ohora.www.service.UserService;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j

public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;


	// 관리자 페이지 요청
	@GetMapping("/auth.htm")
	public String goAuth() {
		return "user.oho_auth";
	}

	// 마이페이지 요청
	@GetMapping("/user/mypage.htm")
	public String goMyPage( Principal principal, Model model ) {
		log.info("myPageController test");
		CustomerUser customUser = (CustomerUser) ((Authentication) principal).getPrincipal();
		log.info("userId : " + customUser.getUser().getUserId());
		int userId = customUser.getUser().getUserId();
		// addrList select
		List<MyPageDTO> myPageOrderList = null;
		myPageOrderList = this.userService.myPageAddrCount(userId);
		model.addAttribute("myPageOrderList", myPageOrderList);
		// ordList select
		List<MyPageDTO> myPageOrdList = null;
		myPageOrdList = this.userService.myPageOrdList(userId);
		model.addAttribute("myPageOrdList", myPageOrdList);
		return "user.oho_myPage";
	}


	// 장바구니 수 select
	@GetMapping("/pdtCount.htm")
	public String pdtCountSelect(Principal principal, HttpSession session, Model model) {
		CustomerUser customUser = (CustomerUser) ((Authentication) principal).getPrincipal();
		log.info("userId : " + customUser.getUser().getUserId());
		int userId = customUser.getUser().getUserId();
		int pdtCount = this.userService.pdtCountSelect(userId);
		log.info("pdtCount : " + pdtCount);
		session.setAttribute("pdtCount", pdtCount);
		return "redirect:/main.htm";
	}

	// 배송주소록 select
	@GetMapping("/user/addr.htm")
	public String addrSelect(Principal principal, Model model) {
		CustomerUser customUser = (CustomerUser) ((Authentication) principal).getPrincipal();
		log.info("userId : " + customUser.getUser().getUserId());
		int userId = customUser.getUser().getUserId();
		// addr select
		List<AddressDTO> addressSelList = null;
		addressSelList = this.userService.addrSelect(userId);
		model.addAttribute("addressSelList", addressSelList);
		return "user.oho_addr";
	}

	// 배송지 삭제
	@GetMapping("/user/addressDelBtn.htm")
	public String addrDelete(@RequestParam("addr_id") List<Integer> addrId) {
		log.info("@@@@@@@@@@@@@@addrId" + addrId);
		int rowCount = this.userService.addrDelete(addrId);
		if (rowCount >= 1) {
			return "redirect:/user/addr.htm";
		} else {
			return "redirect:/user/addr.htm?delete=fail";
		} // if else
	}

	// 배송주소록 기본 배송지 변경
	@GetMapping("/user/addressMain.htm")
	public String addrSelect(Principal principal, Model model
			, @RequestParam("addrId") int addrId) {
		CustomerUser customUser = (CustomerUser) ((Authentication) principal).getPrincipal();
		log.info("userId : " + customUser.getUser().getUserId());
		int userId = customUser.getUser().getUserId();
		// 기본 배송지 변경
		int rowCount = (int) this.userService.mainChange(userId, addrId);
		if (rowCount >= 2) {
			return "redirect:/user/addr.htm";
		} else {
			return "redirect:/user/addr.htm?change=fail";
		} // if else
	}

	// orderDetail select
		// ordPk=${orderDetail.ordPk}&opdtName=${orderDetail.opdtName}&opdtId=${orderDetail.opdtId}"
		@GetMapping("/user/orderDetail.htm")
		public String orderDetail(Principal principal, Model model
				, @RequestParam("ordPk") int ordPk
				, @RequestParam("opdtName") String opdtName
				, @RequestParam("opdtId") int opdtId) {
			CustomerUser customUser = (CustomerUser) ((Authentication) principal).getPrincipal();
			log.info("userId : " + customUser.getUser().getUserId());
			int userId = customUser.getUser().getUserId();
			log.info("@@@@@@@@@@@@@@@@@@@@@@@@" + ordPk + opdtName + opdtId);
			//리뷰 썼는지 여부 CHECK
			int rvck = this.userService.rvck(opdtId);
			model.addAttribute("rvck" , rvck);
			//opdtId
			model.addAttribute("opdtId", opdtId);
			model.addAttribute("ordPk", ordPk);
			// topList
			List<OrderDetailDTO> topList = null;
			topList = this.userService.topList(userId, ordPk);
			model.addAttribute("topList", topList);
			// orderList
			List<OrderDetailDTO> orderList = null;
			orderList = this.userService.orderList(userId, opdtId);
			model.addAttribute("orderList", orderList);
			// orderList2
			List<OrderDetailDTO> orderList2 = null;
			orderList2 = this.userService.orderList2(opdtName);
			model.addAttribute("orderList2", orderList2);
			// addrList
			List<OrderDetailDTO> addrList = null;
			addrList = this.userService.addrList(userId);
			model.addAttribute("addrList", addrList);
			return "user.oho_orderDetail";
		}


	// 로그인 창
	@GetMapping("/login.htm")
	public String goLogin() {
		return "user.oho_login";
	}
	
	// 회원가입 창 /user/join.htm -> /user/oho_join.jsp
	   @GetMapping("/goJoin1.htm")
	    public String join() {
	       log.info("test");
	        return "user.oho_join1"; // 일단 로그인으로 수정함
	    }
	   
	   // 회원가입 창 /user/join.htm + POST  -> oho_join2 회원가입 완료 페이지로 응답
	    @PostMapping("/join2.htm")
	      public String join( Model model, UserDTO dto, @RequestParam("birth-year") String bYear,
	    		  @RequestParam("birth-month") String bMonth, @RequestParam("birth-day") String bDay ) 
	    		 throws Exception{
	       log.info("test1");
	       
	       String StrbirthDay = bYear + "-" + bMonth + "-" + bDay; 
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    Date userBirth = format.parse(StrbirthDay);
	       
		    dto.setUserBirth(userBirth);
		    
	       String encryptedPassword = passwordEncoder.encode(dto.getUserPassword());
	       dto.setUserPassword(encryptedPassword); 
	       log.info("@@@@@@@@@@@@@" + encryptedPassword);
	       
	         Integer successJoin = this.userService.join(dto);
	         
	         if (successJoin > 0) {
	            model.addAttribute("user", dto); 
	            return "user.oho_join2";
	         } else {
	            return "redirect:/goJoin1.htm?fail=true";
	         } // if else
	      } // join
	    
	    
	    
	    
	    
	    // 아이디 찾기 창 /user/findId.htm -> /user/oho_findId1.jsp
	    @GetMapping("/goFindId1.htm")
	     public String findId() {
	        log.info("test");
	         return "user.oho_findId1"; // 일단 로그인으로 수정함
	     }
	    
	    // 아이디 찾기 창 /user/findId.htm + POST  -> oho_findId2.jsp 회원가입 완료 페이지로 응답
	    @PostMapping("/findId2.htm")
	      public String findId( Model model, UserDTO dto) throws Exception{
	       log.info("test");
	       
	       UserDTO findId = this.userService.findUser(dto);
	       
	         if (findId != null) {
	            model.addAttribute("user", findId); 
	            return "user.oho_findId2";
	         } else {
	            return "redirect:/goFindId1.htm?fail=true";
	         } // if else
	      } // join
	    
	    
	    
	    
	    
	    // 비밀번호 찾기 창 /user/findPwd.htm -> /user/oho_findPwd1.jsp
	    @GetMapping("/goPasswd1.htm")
	     public String findPwd() {
	        log.info("test");
	         return "user.oho_findPwd1"; 
	     }
	    
	    
	    // 본인확인
	    @PostMapping("/findPwd2.htm")
	    public String findPwd(Model model, UserDTO dto, @RequestParam("contact_method") String contactMethod) throws Exception {
	        log.info("Selected contact method: " + contactMethod);

	        UserDTO findPwd = this.userService.findPwd(dto);
	        
	        if (findPwd != null) {
	        	model.addAttribute("userID", findPwd);  // 유저 정보 전달
	        	 log.info("Selected contact method: @@@@@" + dto.getUserLoginId());
	        	if ("email".equals(contactMethod)) {
	                model.addAttribute("contactMethod", "email");
	                log.info("Selected contact method: @@@@@" + dto.getUserEmail());
	                model.addAttribute("email", dto.getUserEmail()); // 이메일 정보 전달
	                model.addAttribute("userID", dto.getUserLoginId());
	                return "user.oho_findPwd2";
	            } else if ("phone".equals(contactMethod)) {
	                model.addAttribute("contactMethod", "phone");
	                log.info("Selected contact method: @@@@@" + dto.getUserTel());
	                model.addAttribute("phone", dto.getUserTel()); // 전화번호 정보 전달
	                model.addAttribute("userID", dto.getUserLoginId());
	                return "user.oho_findPwd2";
	            }
	        	
	        } else {
	        	return "redirect:/goPasswd1.htm?fail=true";
	        }
	        
	        return "";

	    }

	    
	    
	    // 비밀번호 변경 창 
	    @PostMapping("/findPwd3.htm")
	    public String changePwd(Model model, UserDTO dto, @RequestParam("userID") String userID) throws Exception{
	       log.info("findPwd33333333Controller test");
	       log.info("@@@@@@@@@@@@@@"+userID);
	       model.addAttribute("userID", userID);
	       return "user.oho_findPwd3";
	    }
	  
	    
	    
	    // 비밀번호 변경
	    @PostMapping("/findPwd4.htm")
	    public String changePwd(Model model, @RequestParam("userID") String userID, 
	                            @RequestParam("new_password") String newPassword, 
	                            @RequestParam("confirm_password") String confirmPassword) throws Exception {
	        
	        log.info("Password change request for UserID: " + userID);
	        
	        // 비밀번호 암호화 (비밀번호를 평문으로 저장하지 않도록 암호화)
	        String encryptedPassword = passwordEncoder.encode(newPassword);
	        
	        // 비밀번호 변경 서비스 호출 (UserService)
	        UserDTO dto = new UserDTO();
	        dto.setUserLoginId(userID);
	        dto.setUserPassword(encryptedPassword);
	        log.info("Password change request for UserID: " + userID);
	        log.info("Password change request for UserID: " + encryptedPassword);
	        
	        Integer successChange = userService.changePwd(dto);
	        
	        log.info("Password change request for UserID: " + dto);
	        
	        // 비밀번호 변경 성공 여부 체크
	        if (successChange > 0) {     
	            return "redirect:/login.htm?change=success";  // 로그인 페이지로 리디렉션
	        } else {
	            return "redirect:/login.htm?change=fail";  // 에러 메시지와 함께 다시 비밀번호 변경 페이지를 반환
	        }
	    }
	
	
	
	
	
	//준용추가 ( 주소지 등록 테스트 페이지 )
	@GetMapping("/addressTEST.htm")
	public String addrInsertTest( ) {
		return "user.addrInsertTEST";
	}
	//준용추가 ( 주소지 등록 페이지 )
	@GetMapping("/addrInsert.htm")
	public String addrInsertPage( ) {
		return "user.oho_addrInsert";
	}
	//준용추가 ( 주소지 등록 작업 POST )
	@PostMapping("/addrInsert.htm")
	public String addrInsert(
			@RequestParam("userId")int userId ,
			@RequestParam("ma_rcv_title") String locationName,
			@RequestParam("ma_rcv_name") String receiverName,
			@RequestParam("address_zip1") String zipCode,
			@RequestParam("address_addr1") String addr1 ,
			@RequestParam("address_addr2") String addr2 ,
			@RequestParam("ma_rcv_mobile_no") String mobile0 ,
			@RequestParam("ma_rcv_mobile_no2") String mobile1 ,
			@RequestParam("ma_rcv_mobile_no3") String mobile2
			) throws SQLException {
		String mobile = mobile0 + "-" + mobile1 + "-" + mobile2;

		System.out.println("넘어온 유저 아이뒤::" + userId);



		this.userService.insertAddr(userId,locationName,receiverName,zipCode,addr1,addr2,mobile);


		return "redirect:/user/addr.htm";
	}
	

} // class
