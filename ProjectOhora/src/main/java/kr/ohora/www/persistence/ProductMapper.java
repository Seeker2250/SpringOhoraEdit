package kr.ohora.www.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.ohora.www.domain.product.ProductDTO;
import kr.ohora.www.domain.product.ProductSearchDTO;

@Mapper
public interface ProductMapper {

	// 페이징 처리 없이 전체 상품 조회(메인화면용)
	public List<ProductDTO> selectAllProducts(@Param("categoryNumber") Integer categoryNumber, @Param("sort") String sort);
	// 메인 주간베스트용
	public List<ProductDTO> selectWeeklyBestProducts(@Param("categoryNumber") Integer categoryNumber, @Param("sort") String sort);
	
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
    
    // 자식 테이블 삭제
    @Delete("DELETE FROM O_PDTCOLOR WHERE PDT_ID = #{productId}")
    int deleteFromPdtColor(int productId);
    @Delete("DELETE FROM O_PDTDESIGN WHERE PDT_ID = #{productId}")
    int deleteFromPdtDesign(int productId);
    @Delete("DELETE FROM O_PDTLINEUP WHERE PDT_ID = #{productId}")
    int deleteFromPdtLineup(int productId);
    @Delete("DELETE FROM O_PDTOPTION WHERE PDT_ID = #{productId}")
    int deleteFromPdtOption(int productId);
    // 부모 테이블 삭제
    @Delete("DELETE FROM O_PRODUCT WHERE PDT_ID = #{productId}")
    int deleteProduct(int productId);

    
    // 상품 정보 업데이트
    int updateProduct(@Param("product") ProductDTO product);

    // 조회수 및 리뷰수 업데이트
    int updateViewAndReviewCounts(@Param("pdtId") int pdtId);

    // 상품 최신 데이터 조회
    ProductDTO selectProductById(@Param("pdtId") int pdtId);

}
