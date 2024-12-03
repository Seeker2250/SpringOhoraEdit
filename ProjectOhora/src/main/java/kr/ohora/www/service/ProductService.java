package kr.ohora.www.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.ohora.www.domain.Criteria;
import kr.ohora.www.domain.product.ProductDTO;

@Service
public interface ProductService {

   public List<ProductDTO> getProductList(int pageNum, int numberPerPage, int categoryNumber, String sort, String keyword);

   public int getTotalRecords(int categoryNumber, String keyword);
    
   public ProductDTO getProductById(int productId);
    
   public List<ProductDTO> getAdditionalProducts(int catId);
   
   // 아울렛용
   public List<ProductDTO> getOutletProducts(int pageNum, int numberPerPage);
    public int getOutletTotalRecords();
    
    //상품 등록
    public int addProduct(ProductDTO product);
    
    // 상품 삭제
    public int deleteProduct(int productId);
    
    // 메인페이지 ajax처리하는 부분 카테고리로...
    public List<ProductDTO> getProductsByCategory(int categoryNumber, String orderBy);
    
    // 상품 정보를 수정하는...
    public void updateProductWithCounts(@Param("product") ProductDTO product, HttpServletRequest request, @Param("multipartFile1") MultipartFile multipartFile1
          , @Param("multipartFile2") MultipartFile multipartFile2, @Param("existingFile1") String existingFile1, @Param("existingFile2") String existingFile2) throws Exception;

}