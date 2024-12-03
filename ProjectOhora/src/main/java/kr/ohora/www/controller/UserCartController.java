package kr.ohora.www.controller;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ohora.www.domain.UserCartDTO;
import kr.ohora.www.domain.security.CustomerUser;
import kr.ohora.www.service.UserCartService;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UserCartController {

	@Autowired
	private UserCartService userCartService;

	// 회원 상세 페이지 장바구니 담기
	@GetMapping("/userCart/addCartBtn.htm")
	public String addCartBtn( Model model
			, Principal principal
			, @RequestParam("pdtId") List<Integer> pdtId
			, @RequestParam("pdtCount") List<Integer> pdtCount
			, HttpSession session
			) throws SQLException {
		log.info("addCartBtnController test");
		CustomerUser customUser = (CustomerUser) ((Authentication) principal).getPrincipal();
		log.info("userId : " + customUser.getUser().getUserId());
		int userId = customUser.getUser().getUserId();
		log.info("@@@@@@@@@@@@@@@@@@@@ pdtId" + pdtId);
		log.info("@@@@@@@@@@@@@@@@@@@@ pdtCount" + pdtCount);

		// 회원 상세 페이지 장바구니 담기
		Integer count = this.userCartService.addCartBtn(userId, pdtId, pdtCount);
		log.info("@@@@@@@@@@@@@@@@@@@@ count" + count);

		if (count == null) {
			return "redirect:/userCart/select.htm";
		} else {
			Object oldPdtCount = session.getAttribute("pdtCount");
			oldPdtCount = (int) oldPdtCount + count;
			session.setAttribute("pdtCount", oldPdtCount);
			return "redirect:/userCart/select.htm";
		} // if else
	}

	// 회원 장바구니 select
	@GetMapping("/userCart/select.htm")
	public String userCartSelect( Model model
			, Principal principal
			) throws SQLException {

		log.info("userCartSelectController test");

		CustomerUser customUser = (CustomerUser) ((Authentication) principal).getPrincipal();

		log.info("userId : " + customUser.getUser().getUserId());

		int userId = customUser.getUser().getUserId();

		List<UserCartDTO> userCartList = null;

		userCartList = this.userCartService.userCartSelect(userId);

		model.addAttribute("userCartList", userCartList);

		return "userCart.oho_userCart";
	}

	// 회원 장바구니 수량 감소
	@GetMapping("/userCart/minusBtn.htm")
	public String userCartMinusBtn( @RequestParam("clistId") int clistId, @RequestParam("clistPdtCount") int clistPdtCount ) throws SQLException {

		log.info("userCartMinusBtnController test");

		log.info("clistId : " + clistId);
		log.info("clistPdtCount : " + clistPdtCount);

		int rowCount = this.userCartService.userCartMinusBtn(clistId, clistPdtCount);

		if (rowCount == 1) {
			return "redirect:/userCart/select.htm";
		} else {
			return "redirect:/userCart/select.htm?minus=fail";
		} // if else

	}

	// 회원 장바구니 수량 증가
	@GetMapping("/userCart/plusBtn.htm")
	public String userCartPlusBtn( @RequestParam("clistId") int clistId ) throws SQLException {

		log.info("userCartPlusBtnController test");

		log.info("clistId : " + clistId);

		int rowCount = this.userCartService.userCartPlusBtn(clistId);

		if (rowCount == 1) {
			return "redirect:/userCart/select.htm";
		} else {
			return "redirect:/userCart/select.htm?plus=fail";
		} // if else

	}

	// 회원 장바구니 상품 삭제
	@GetMapping("/userCart/delBtn.htm")
	public String userCartDelBtn( @RequestParam("clistId") int clistId, HttpSession session ) throws SQLException {

		log.info("userCartDelBtnController test");

		log.info("clistId : " + clistId);

		int rowCount = this.userCartService.userCartDelBtn(clistId);

		if (rowCount == 1) {
			Object oldPdtCount = session.getAttribute("pdtCount");
			oldPdtCount = (int) oldPdtCount - 1;
			session.setAttribute("pdtCount", oldPdtCount);
			return "redirect:/userCart/select.htm";
		} else {
			return "redirect:/userCart/select.htm?del=fail";
		} // if else

	}

} // class
