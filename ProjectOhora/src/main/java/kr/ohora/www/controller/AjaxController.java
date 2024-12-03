package kr.ohora.www.controller;

import java.security.Principal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ohora.www.domain.product.ProductDTO;
import kr.ohora.www.domain.security.CustomerUser;
import kr.ohora.www.service.ProductService;
import kr.ohora.www.service.UserCartService;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class AjaxController {
	
	@Autowired
	UserCartService userCartService;
	
	// 회원 장바구니 담기
	@PostMapping("/userCart/addCart.ajax")
	@ResponseBody
	public Map<String, Object> userCartAddCart(@RequestParam("pdt_id") int pdtId, 
	                                           Principal principal, 
	                                           HttpSession session) throws SQLException {
	    log.info("userCartAddCart test");
	    log.info("@@@@@@@@@@@@@@@@@@@pdtId : " + pdtId);

	    // 사용자 ID 가져오기
	    CustomerUser customUser = (CustomerUser) ((Authentication) principal).getPrincipal();
	    log.info("userId : " + customUser.getUser().getUserId());
	    int userId = customUser.getUser().getUserId();

	    // JSON 응답 데이터
	    Map<String, Object> response = new HashMap<>();

	    // 기존 장바구니 확인
	    Integer check = this.userCartService.userCartCheck(userId, pdtId);
	    Integer oldPdtCount = (Integer) session.getAttribute("pdtCount");
	    if (oldPdtCount == null) {
	        oldPdtCount = 0;
	    }

	    if (check == null) {
	        // 신규 상품 추가
	        int insertCount = this.userCartService.userCartAddCartInsert(userId, pdtId);
	        if (insertCount == 1) {
	            session.setAttribute("pdtCount", oldPdtCount + insertCount);
	            response.put("success", true);
	            response.put("message", "상품이 장바구니에 추가되었습니다.");
	            response.put("newCartCount", oldPdtCount + insertCount);
	        } else {
	            response.put("success", false);
	            response.put("message", "상품 추가에 실패했습니다.");
	        }
	    } else {
	        // 기존 상품 수량 증가
	        int CountUp = this.userCartService.userCartAddCartCountUp(userId, pdtId);
	        if (CountUp == 1) {
	            session.setAttribute("pdtCount", oldPdtCount);
	            response.put("success", true);
	            response.put("message", "상품 수량이 증가되었습니다.");
	            response.put("newCartCount", oldPdtCount);
	        } else {
	            response.put("success", false);
	            response.put("message", "상품 수량 증가에 실패했습니다.");
	        }
	    }

	    return response;
	}

	@Autowired
    private ProductService productService;

    @GetMapping(value = "/fetchProducts.ajax", produces = "application/json")
    public List<ProductDTO> fetchProducts(
            @RequestParam(defaultValue = "0") int categoryNumber,
            @RequestParam(defaultValue = "sales") String sortBy) {
        // 요청된 카테고리와 정렬 기준에 따라 상품 목록 반환
        return productService.getProductsByCategory(categoryNumber, sortBy);
    }
	
	
	
	
} // class