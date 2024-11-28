package kr.ohora.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ohora.www.domain.product.ProductDTO;
import kr.ohora.www.domain.product.ProductSearchDTO;
import kr.ohora.www.persistence.ProductMapper;

@Service
public class ProductService {

	 @Autowired
	    private ProductMapper productMapper;

	 public List<ProductDTO> getProductList(int currentPage, int numberPerPage, int categoryNumber) {
		    // 페이징 계산
		    int start = (currentPage - 1) * numberPerPage + 1;
		    int end = start + numberPerPage - 1;

		    // 검색 조건 DTO 생성
		    ProductSearchDTO searchDTO = new ProductSearchDTO();
		    searchDTO.setStart(start);
		    searchDTO.setEnd(end);
		    searchDTO.setCategoryNumber(categoryNumber);

		    // Mapper 호출
		    return productMapper.selectProducts(searchDTO);
		}

	    public int getTotalRecords(int categoryNumber) {
	        // 총 레코드 수 조회
	        return productMapper.getTotalRecords(categoryNumber);
	    }
}