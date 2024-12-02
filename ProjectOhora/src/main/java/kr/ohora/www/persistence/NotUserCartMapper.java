package kr.ohora.www.persistence;

import java.util.ArrayList;
import java.util.List;

import kr.ohora.www.domain.product.ProductDTO;

public interface NotUserCartMapper {

	 List<ProductDTO> pdtsFromIds(List<Integer> productIds);
}
