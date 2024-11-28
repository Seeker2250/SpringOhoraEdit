package kr.ohora.www.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.ohora.www.domain.product.ProductDTO;
import kr.ohora.www.domain.product.ProductSearchDTO;

public interface ProductMapper {

	//ArrayList<ProductDTO> select(int currentPage, int numberPerPage) throws SQLException;
	// 페이징 및 카테고리별 상품 조회
	public List<ProductDTO> selectProducts(ProductSearchDTO searchDTO);

	// 1-3. 총 레코드 수
	//int getTotalRecords() throws SQLException;
	
	// 메인페이지에 뿌릴 상품 정보 가져오는...
	//ArrayList<ProductDTO> getAllProducts() throws SQLException;

	//int getTotalRecords(int categoryNumber) throws SQLException;
    // 총 레코드 수 조회
    public int getTotalRecords(@Param("categoryNumber") int categoryNumber);
    
	//int getTotalRecords(String searchCondition, String searchWord) throws SQLException;
	
	// 1-4. 총 페이지 수
	//int getTotalPages(int numberPerPage, int categoryNumber) throws SQLException;

	// 검색시 총페이지
	//int getTotalPages(int numberPerPage, String searchCondition, String keyword) throws SQLException;

	// 카테고리 적용해서 조회
	//ArrayList<ProductDTO> selectProducts(int currentPage, int numberPerPage, int categoryNumber) throws SQLException;

	//int getTotalRecordsByProductName(String searchWord) throws SQLException;

	//ArrayList<ProductDTO> selectByProductName(String searchWord, int currentPage, int numberPerPage) throws SQLException;
	
	//ArrayList<ProductDTO> selectProductsByCreatedDate(int currentPage, int numberPerPage, int categoryNumber) throws SQLException;

	//ArrayList<ProductDTO> selectProductsBySales(int currentPage, int numberPerPage, int categoryNumber) throws SQLException;

	//ArrayList<ProductDTO> selectProductsByViewcount(int currentPage, int numberPerPage, int categoryNumber) throws SQLException;

	//ProductDTO selectProductById(int pdtId) throws SQLException;
	
	// 조회수 증가
	//int hitUp(int pdtId) throws SQLException;
	int hitUp();
	//ArrayList<ProductDTO> selectProductsOutlet(int currentPage, int numberPerPage) throws SQLException;

	//int getTotalRecordsForOutlet() throws SQLException;
	
	// 아울렛 용 총 페이지
	//int getTotalPagesForOutlet(int numberPerPage) throws SQLException;

	// 상세 페이지 장바구니 담기 처리
	//boolean addCartBtn(int userId, String[] pdtIds, String[] pdtCounts, HttpServletRequest request);

}
