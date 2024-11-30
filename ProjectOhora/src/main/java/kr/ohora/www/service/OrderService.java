package kr.ohora.www.service;

import java.util.List;

import kr.ohora.www.domain.UserDTO;
import kr.ohora.www.domain.product.ProductDTO;


public interface OrderService {
    UserDTO getUserInfo(int userId);
    List<AddrDTO> getAddrList(int userId);
    List<CouponDTO> getCouponList(int userId);
    List<ProductDTO> getProductList(String[] pdtIds);
}

