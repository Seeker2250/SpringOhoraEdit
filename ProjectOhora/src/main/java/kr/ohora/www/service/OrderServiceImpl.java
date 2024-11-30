package kr.ohora.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ohora.www.domain.UserDTO;
import kr.ohora.www.domain.product.ProductDTO;
import kr.ohora.www.persistence.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService{
	 @Autowired
	 private OrderMapper orderMapper;
	 
	@Override
	public List<AddrDTO> getAddrList(int userId) {
		return orderMapper.selectAddrList(userId);
	}

	@Override
	public List<CouponDTO> getCouponList(int userId) {
		return orderMapper.selectCouponList(userId);
	}

	@Override
	public List<ProductDTO> getProductList(String[] pdtIds) {
		return orderMapper.selectProductList(pdtIds);
	}

	@Override
	public UserDTO getUserInfo(int userId) {
		return orderMapper.selectUserInfo(userId);
	}

}
