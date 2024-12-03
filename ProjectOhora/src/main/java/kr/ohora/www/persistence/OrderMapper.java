package kr.ohora.www.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.ohora.www.domain.AddrDTO;
import kr.ohora.www.domain.UserDTO;
import kr.ohora.www.domain.order.OrderDTO;
import kr.ohora.www.domain.product.ProductDTO;

public interface OrderMapper {

	int insertOrder(OrderDTO order);//주문에 insert
	int checkPoint(@Param("userId") int userId);//유저 포인트 몇이여
	int updateUsePoint(@Param("userId") int userId, @Param("updatedPoint") int updatedPoint);//포인트 업뎃
	
	/*
	 * OPDT_ID, <!-- 시퀀스 필요 --> 
	 * ORD_PK, <!-- 주문 PK --> 
	 * OPDT_NAME, OPDT_AMOUNT,
	 * OPDT_DCAMOUNT, 
	 * OPDT_COUNT, OPDT_STATE, <!-- 상태 - 기본값 '상품준비중' -->
	 *  OPDT_CONFIRM
	 * <!-- 구매
	 */
	int insertOrderDetail(
			ProductDTO order
    );//주문 상세를 orddetail에 넣어
	
	int deleteCart(
            @Param("userId") int userId,
            @Param("pdtId") int pdtId
    );//장바구니에서 상품 삭제
	int deleteCoupon(@Param("icpnId") int icpnId);//쓴 쿠폰 지워
	
	UserDTO selectUserInfo(int userId);
    List<AddrDTO> selectAddrList(int userId);
   // List<CouponDTO> selectCouponList(int userId);
    List<ProductDTO> selectProductList(int[] pdtIds);
}
