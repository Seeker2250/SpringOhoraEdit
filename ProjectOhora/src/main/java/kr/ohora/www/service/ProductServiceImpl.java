package kr.ohora.www.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
   
   @Override
   @Transactional
   public int deleteProduct(int productId) {
      // 1. 자식 테이블 데이터 삭제
        productMapper.deleteFromPdtColor(productId);
        productMapper.deleteFromPdtDesign(productId);
        productMapper.deleteFromPdtLineup(productId);
        productMapper.deleteFromPdtOption(productId);

        // 2. 부모 테이블 데이터 삭제
        return productMapper.deleteProduct(productId);
    }
   
   // 메인 페이지 ajax
    public List<ProductDTO> getProductsByCategory(int categoryNumber, String orderBy) {
        return productMapper.selectWeeklyBestProducts(categoryNumber, orderBy);
    }
    
    @Transactional
    public void updateProductWithCounts(
          @Param("product") ProductDTO product, 
           HttpServletRequest request,
          @Param("multipartFile1") MultipartFile multipartFile1, 
          @Param("multipartFile2") MultipartFile multipartFile2, 
          @Param("existingFile1") String existingFile1, 
          @Param("existingFile2") String existingFile2) throws Exception {
        // 최신 조회수 및 리뷰수 가져오기
        ProductDTO latestProduct = productMapper.selectDetailViewProduct(product.getPdtId());
        product.setPdtViewcount(latestProduct.getPdtViewcount());
        product.setPdtReviewCount(latestProduct.getPdtReviewCount());

        // 파일 업로드 처리
        //String uploadRealPath = "C:\\upload";
        //String uploadRealPath = "C:\\Users\\User\\Desktop\\SpringOhora\\ProjectOhora\\src\\main\\webapp\\resources\\images\\product_image";
        String uploadRealPath = request.getServletContext().getRealPath("/resources/images/product_image/");
        File uploadDir = new File(uploadRealPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // 이미지 1 업로드 처리
        if (!multipartFile1.isEmpty()) {
            String originalFilename1 = multipartFile1.getOriginalFilename();
            String filesystemName1 = UUID.randomUUID().toString() + "_" + originalFilename1;
            File dest1 = new File(uploadRealPath, filesystemName1);
            multipartFile1.transferTo(dest1);
            product.setPdtImgUrl(filesystemName1);
        } else {
            product.setPdtImgUrl(existingFile1);
        }

        // 이미지 2 업로드 처리
        if (!multipartFile2.isEmpty()) {
            String originalFilename2 = multipartFile2.getOriginalFilename();
            String filesystemName2 = UUID.randomUUID().toString() + "_" + originalFilename2;
            File dest2 = new File(uploadRealPath, filesystemName2);
            multipartFile2.transferTo(dest2);
            product.setPdtImgUrl2(filesystemName2);
        } else {
            product.setPdtImgUrl2(existingFile2);
        }

        try {
            productMapper.updateProduct(product);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update product@@@@@@@@@@@: " + product.getPdtId(), e);
        }

        // 조회수 및 리뷰수 증가 (변동 가능)
       productMapper.updateViewAndReviewCounts(product.getPdtId());
    }

}
