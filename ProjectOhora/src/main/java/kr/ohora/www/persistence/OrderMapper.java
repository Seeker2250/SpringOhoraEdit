package kr.ohora.www.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.ohora.www.domain.AddrDTO;
import kr.ohora.www.domain.UserDTO;
import kr.ohora.www.domain.order.OrderDTO;
import kr.ohora.www.domain.product.ProductDTO;

public interface OrderMapper {

	String insertOrder(OrderDTO order);//주문에 insert
	int checkPoint(@Param("userId") int userId);//유저 포인트 몇이여
	int updateUsePoint(@Param("userId") int userId, @Param("updatedPoint") int updatedPoint);//포인트 업뎃
	int insertOrderDetail(
            @Param("orderId") String orderId,
            @Param("pdtName") String pdtName,
            @Param("pdtCount") int pdtCount,
            @Param("pdtAmount") int pdtAmount,
            @Param("pdtDcAmount") int pdtDcAmount
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
