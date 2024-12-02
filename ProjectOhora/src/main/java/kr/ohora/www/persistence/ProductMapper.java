package kr.ohora.www.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ohora.www.domain.Criteria;
import kr.ohora.www.domain.product.ProductDTO;
import kr.ohora.www.domain.product.ProductSearchDTO;

@Mapper
public interface ProductMapper {

	// 페이징 처리 없이 전체 상품 조회(메인화면용)
	public List<ProductDTO> selectAllProducts(@Param("categoryNumber") Integer categoryNumber, @Param("sort") String sort);
	
	// 페이징 및 카테고리별 상품 조회 / 정렬까지
	public List<ProductDTO> selectProducts(ProductSearchDTO searchDTO);
	 
    // 총 레코드 수 조회 / 검색어도...
	public int getTotalRecords(@Param("categoryNumber") int categoryNumber, @Param("keyword") String keyword);
    
    // 상세페이지 상품 조회
    public ProductDTO selectDetailViewProduct(@Param("productId") int productId);

	// 조회수 증가
	public int hitUp(@Param("productId") int productId);
	
	//아울렛용
	List<ProductDTO> selectOutletProducts(@Param("start") int start, @Param("end") int end);
    int getOutletTotalRecords();
    
    //상품 등록
    int insertProduct(ProductDTO product);


}
