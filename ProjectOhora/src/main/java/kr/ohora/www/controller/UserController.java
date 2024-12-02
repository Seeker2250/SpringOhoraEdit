package kr.ohora.www.controller;

import java.security.Principal;
import java.sql.SQLException;
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

	@GetMapping("/login.htm")
	public String goLogin() {
		return "user.oho_login";
	}

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

	// 회원가입 창 /user/join.htm -> /user/oho_join.jsp
	@GetMapping("/join.htm")
	public String join() {
		log.info("JoinController test");
		return "user.oho_join";
	}


	// 회원가입 창 /user/join.htm + POST  -> home2 응답
	@PostMapping("/join.htm")
	public String join( Model model, UserDTO dto) throws Exception{
		log.info("JoinController test1");

		String encryptedPassword = passwordEncoder.encode(dto.getUserPassword());
		dto.setUserPassword(encryptedPassword); 
		log.info("@@@@@@@@@@@@@" + encryptedPassword);

		log.info("JoinController test2");
		Integer successJoin = this.userService.join(dto);
		log.info("JoinController test3");
		if (successJoin  > 0) {
		} // if
		if (successJoin > 0) {
			model.addAttribute("successJoin", successJoin);
			return "user.oho_joinOk";
		} else {
			return "user.oho_joinError";
		} // if else
	} // join


	
	
	
	
	
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
