package kr.ohora.www.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ohora.www.domain.product.ProductDTO;
import kr.ohora.www.domain.product.ProductSearchDTO;
import kr.ohora.www.persistence.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDTO> getProductList(int pageNum, int numberPerPage, int categoryNumber, String sort, String keyword) {
        int start = (pageNum - 1) * numberPerPage + 1;
        int end = start + numberPerPage - 1;
        // 시간 체크해보자
        
        ProductSearchDTO searchDTO = new ProductSearchDTO();
        searchDTO.setCategoryNumber(categoryNumber);
        searchDTO.setSort(sort);
        searchDTO.setKeyword(keyword);
        searchDTO.setStart(start);
        searchDTO.setEnd(end);
        
        return productMapper.selectProducts(searchDTO);
    }

    public int getTotalRecords(int categoryNumber, String keyword) {
        ProductSearchDTO searchDTO = new ProductSearchDTO();
        searchDTO.setCategoryNumber(categoryNumber);
        searchDTO.setKeyword(keyword);

        return productMapper.getTotalRecords(categoryNumber, keyword);
    }

	@Override
	public ProductDTO getProductById(int productId) {
		 // 조회수 증가
        productMapper.hitUp(productId);
        // 상품 정보 반환
        return productMapper.selectDetailViewProduct(productId);
	}

	@Override
	public List<ProductDTO> getAdditionalProducts(int catId) {
		List<Integer> additionalProductIds;

        // 카테고리별 추가 구성 상품 ID 매핑
        switch (catId) {
            case 1:
                additionalProductIds = Arrays.asList(170, 174, 169, 172);
                break;
            case 2:
                additionalProductIds = Arrays.asList(170, 169);
                break;
            case 3:
                additionalProductIds = Arrays.asList(173, 175, 169);
                break;
            default:
                additionalProductIds = new ArrayList<>();
        }

        // 추가 구성 상품 정보 조회
        List<ProductDTO> additionalProducts = new ArrayList<>();
        for (int id : additionalProductIds) {
            ProductDTO product = productMapper.selectDetailViewProduct(id);
            if (product != null) {
                additionalProducts.add(product);
            }
        }
        return additionalProducts;
    }
	
	
	@Override
	public List<ProductDTO> getOutletProducts(int pageNum, int numberPerPage) {
	    return productMapper.selectOutletProducts(pageNum, numberPerPage);
	}

	@Override
	public int getOutletTotalRecords() {
	    return productMapper.getOutletTotalRecords();
	}
	

	@Override
    public int addProduct(ProductDTO product) {
        return productMapper.insertProduct(product);
    }

}
