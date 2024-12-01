package kr.ohora.www.service.order;

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
        String orderId = orderMapper.insertOrder(order);
        if (orderId == null) {
            throw new RuntimeException("insertOrder하다가 터짐요");
        }
		
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
                    throw new RuntimeException("Failed to update user points");
                }
            } else {
                log.warn("Insufficient points for userId: " + order.getUserId());
                throw new RuntimeException("Insufficient points");
            }
        }
        
     // 주문 상세에 insert
        for (int i = 0; i < order.getPdtName().length; i++) {
        	int insertDetailCount = orderMapper.insertOrderDetail(
                    orderId,
                    order.getPdtName()[i],
                    order.getPdtCount()[i],
                    order.getPdtAmount()[i],
                    order.getPdtDcAmount()[i]
            );
            if (insertDetailCount != 1) {
                throw new RuntimeException("Failed to insert order detail for product: " + order.getPdtName()[i]);
            }
        }
        
     // 장바구니 삭제
        for (int i = 0; i < order.getPdtId().length; i++) {
        	 int deleteCartCount = orderMapper.deleteCart(order.getUserId(), order.getPdtId()[i]);
             if (deleteCartCount != 1) {
                 throw new RuntimeException("장바구니 삭제 중 오류 발생: 상품 ID " + order.getPdtId()[i]);
             }
        }
        log.info("주문 성공한 애 주문 번호는 " + orderId);
        return orderId;
	 } catch (Exception e) {
         log.error("주문 하다가 조짐", e);
         throw new RuntimeException("주문 하다가 조져서 던짐", e);
     }
		
	}
	
	@Override
	public List<AddrDTO> getAddrList(int userId) {
		return orderMapper.selectAddrList(userId);
	}

	/*
	 * @Override public List<CouponDTO> getCouponList(int userId) { return
	 * orderMapper.selectCouponList(userId); }
	 */

	@Override
	public List<ProductDTO> getProductList(int[] pdtIds) {
		return orderMapper.selectProductList(pdtIds);
	}

	@Override
	public UserDTO getUserInfo(int userId) {
		return orderMapper.selectUserInfo(userId);
	}

}
