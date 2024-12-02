package kr.ohora.www.service.order;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ohora.www.domain.AddrDTO;
import kr.ohora.www.domain.UserDTO;
import kr.ohora.www.domain.order.OrderDTO;
import kr.ohora.www.domain.product.ProductDTO;
import kr.ohora.www.persistence.OrderMapper;
import lombok.extern.log4j.Log4j;

@Service
@Transactional
@Log4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public String order(OrderDTO order) {
	 try {
		
		 
		 // 주문 INSERT
		//  int로 결과를 받지만 DTO에는 ordId가 설정 되겠지!!!!
		 int result = orderMapper.insertOrder(order);
	        if (result != 1) {
	            throw new RuntimeException("insertOrder하다가 터짐요");
	        }
	        
        String orderId = order.getOrdId();  // selectKey로 설정된 값 사용
		
        if (order.getIcpnId() != 0) {
            orderMapper.deleteCoupon(order.getIcpnId());//쿠폰 컷
        }
		
        
        // 적립금 3000원 이상인 애꺼 가져와서 쓰겠다고 하면 업데이트 시켜
        if (order.getInputPoint() >= 3000) {
            int currentPoint = orderMapper.checkPoint(order.getUserId());
            if (currentPoint >= 3000 && currentPoint >= order.getInputPoint()) {
                int updatedPoint = currentPoint - order.getInputPoint();
                int rowCount = orderMapper.updateUsePoint(order.getUserId(), updatedPoint);
                if (rowCount != 1) {
                    throw new RuntimeException("포인트 업데이트 하다가 조짐");
                }
            } else {
                log.warn("포인트 없는 애: " + order.getUserId());
                throw new RuntimeException("포인트 없대요");
            }
        }
     // 주문 상세 insert
        int insertDetailCount = orderMapper.insertOrderDetail(order);
        if (insertDetailCount != order.getPdtId().size()) {
            throw new RuntimeException("order detail하다가 조짐");
        }
        
     /// 장바구니 삭제
     for (Integer pdtId : order.getPdtId()) {
         int deleteCartCount = orderMapper.deleteCart(order.getUserId(), pdtId);
         if (deleteCartCount != 1) {
             throw new RuntimeException("장바구니 삭제 중 오류터짐 상품 아이디 " + pdtId);
         }
     }
        log.info("주문 성공한 애 주문 번호는 " + orderId);
        return orderId;
	 } catch (Exception e) {
         log.error("주문 하다가 조짐", e);
         throw new RuntimeException("걍 insert order에서 싸그리 try에서 튕겨서 던짐", e);
     }
		
	}
	
	@Override
	public List<AddrDTO> getAddrList(int userId) {
		return orderMapper.selectAddrList(userId);
	}

	
	 // @Override public List<CouponDTO> getCouponList(int userId) { return
	 // orderMapper.selectCouponList(userId); }
	 

	@Override
	public List<ProductDTO> getProductList(int[] pdtIds) {
		return orderMapper.selectProductList(pdtIds);
	}

	@Override
	public UserDTO getUserInfo(int userId) {
		return orderMapper.selectUserInfo(userId);
	}

	@Override
	public int insertOrder(OrderDTO order) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int deleteCart(int userId, int pdtId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AddrDTO> selectAddrList(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
