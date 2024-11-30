package kr.ohora.www.persistence;

import java.util.List;

import kr.ohora.www.domain.UserDTO;
import kr.ohora.www.domain.product.ProductDTO;

public interface OrderMapper {
	UserDTO selectUserInfo(int userId);
    List<AddrDTO> selectAddrList(int userId);
    List<CouponDTO> selectCouponList(int userId);
    List<ProductDTO> selectProductList(String[] pdtIds);
}
