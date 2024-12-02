package kr.ohora.www.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.ohora.www.domain.Criteria;
import kr.ohora.www.domain.product.ProductDTO;

@Service
public interface ProductService {

	public List<ProductDTO> getProductList(int pageNum, int numberPerPage, int categoryNumber, String sort, String keyword);

	public int getTotalRecords(int categoryNumber, String keyword);
	 
	public ProductDTO getProductById(int productId);
	 
	public List<ProductDTO> getAdditionalProducts(int catId);
	
	// 아울렛용
	List<ProductDTO> getOutletProducts(int pageNum, int numberPerPage);
    int getOutletTotalRecords();
    
    //상품 등록
    int addProduct(ProductDTO product);

}