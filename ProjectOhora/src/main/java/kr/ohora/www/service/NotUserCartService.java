package kr.ohora.www.service;

import java.util.List;

import kr.ohora.www.domain.product.ProductDTO;

public interface NotUserCartService {

	 List<ProductDTO> getProductsByIds(List<Integer> productIds);
}
