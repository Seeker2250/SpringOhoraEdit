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
}
