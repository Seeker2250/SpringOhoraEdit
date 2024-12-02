package kr.ohora.www.service.order;

import java.util.List;

import kr.ohora.www.domain.AddrDTO;
import kr.ohora.www.domain.UserDTO;
import kr.ohora.www.domain.order.OrderDTO;
import kr.ohora.www.domain.product.ProductDTO;

public interface OrderService {
	
	String order(OrderDTO order);
	UserDTO getUserInfo(int userId);
    List<AddrDTO> getAddrList(int userId);
    List<ProductDTO> getProductList(int[] pdtIds);
    
	 int insertOrder(OrderDTO order);

	    // 유저 포인트 조회
	    //int checkPoint(int userId);

	    // 포인트 업데이트
	   // int updateUsePoint(int userId, int updatedPoint);

	    // 주문 상세 정보 추가
	    //int insertOrderDetail(OrderDTO order);

	    // 장바구니에서 상품 삭제
	    int deleteCart(int userId, int pdtId);

	    // 쿠폰 삭제
	   // int deleteCoupon(int icpnId);

	    // 유저 정보 조회
	   // UserDTO selectUserInfo(int userId);

	    // 유저의 주소 목록 조회
	    List<AddrDTO> selectAddrList(int userId);

	    // 상품 목록 조회
	    //List<ProductDTO> selectProductList(int[] pdtIds);
}
