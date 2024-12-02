package kr.ohora.www.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ohora.www.domain.Criteria;
import kr.ohora.www.domain.PageDTO;
import kr.ohora.www.domain.product.ProductDTO;
import kr.ohora.www.persistence.ProductMapper;
import kr.ohora.www.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
    private ProductService productService;
	@Autowired
	private ProductMapper productMapper;
	// 메인페이지
	@GetMapping("/main.htm")
	public String main(@RequestParam(defaultValue = "0") Integer categoryNumber,
                              @RequestParam(defaultValue = "adddate") String sort,
                              Model model) {
	    List<ProductDTO> products = productMapper.selectAllProducts(categoryNumber, sort);
	    model.addAttribute("products", products);
		return "product.oho_main";
	}
	// 상품 목록 페이지
	@GetMapping("/prdList.htm")
	public String prdList(
	    @RequestParam(defaultValue = "1") int pageNum, // 현재 페이지
	    @RequestParam(defaultValue = "12") int numberPerPage, // 페이지당 항목 수
	    @RequestParam(defaultValue = "0") int categoryNumber, // 카테고리 번호
	    @RequestParam(required = false) String keyword, // 검색어
	    @RequestParam(required = false) String sort, // 정렬 기준
	    Model model,
	    Criteria criteria) {

	    // 상품 리스트와 총 레코드 수 가져오기
	    List<ProductDTO> productList = productService.getProductList(pageNum, numberPerPage, categoryNumber, sort, keyword);
	    int totalRecords = productService.getTotalRecords(categoryNumber, keyword);

	    // 모델에 데이터 추가
	    model.addAttribute("list", productList); // 상품 리스트
	    model.addAttribute("categoryNumber", categoryNumber); // categoryNumber 추가
	    model.addAttribute("totalRecords", totalRecords); // 총 레코드 수
	    model.addAttribute("pageNum", pageNum); // 현재 페이지
	    model.addAttribute("numberPerPage", numberPerPage); // 페이지당 항목 수
	    model.addAttribute("pageMaker", new PageDTO(criteria, totalRecords));
	    model.addAttribute("keyword",keyword);

	    return "product.prdList"; 
	}
	//아울렛 페이지
	@GetMapping("/outlet.htm")
    public String outlet(
    		 @RequestParam(defaultValue = "1") int pageNum, // 현재 페이지
    		    @RequestParam(defaultValue = "12") int numberPerPage, // 페이지당 항목 수
    		    @RequestParam(defaultValue = "0") int categoryNumber, // 카테고리 번호
    		    @RequestParam(required = false) String keyword, // 검색어
    		    @RequestParam(required = false) String sort, // 정렬 기준
    		    Model model,
    		    Criteria criteria) {

        // 아울렛 상품 리스트 가져오기
        List<ProductDTO> outletProducts = productService.getOutletProducts(pageNum, numberPerPage);
        int totalRecords = productService.getOutletTotalRecords();

        // 모델에 데이터 추가
        model.addAttribute("list", outletProducts);
        model.addAttribute("categoryNumber", categoryNumber); // categoryNumber 추가
        model.addAttribute("totalRecords", totalRecords);
        model.addAttribute("pageNum", pageNum); // 현재 페이지
	    model.addAttribute("numberPerPage", numberPerPage); // 페이지당 항목 수
	    model.addAttribute("pageMaker", new PageDTO(criteria, totalRecords));

        return "product.prdList";
    }
	
	// 상품 상세 페이지
	@GetMapping("/prdDetailView.htm")
    public String prdDetailView(@RequestParam("productId") int productId, Model model) {
        // 상품 정보 조회
        ProductDTO productDTO = productService.getProductById(productId);
        model.addAttribute("product", productDTO);

        // 추가 구성 상품 조회
        List<ProductDTO> additionalProducts = productService.getAdditionalProducts(productDTO.getCatId());
        model.addAttribute("additionalProducts", additionalProducts);

        return "product.prdDetailView";
    }
	
	// 상품 등록 페이지 이동
	@GetMapping("/prdAdd.htm")
	public String showProductAddPage() {
	    return "product.prdAdd"; // `WEB-INF/views/product/prdAdd.jsp`
	}
	
	// 파일명 중복 체크
	private String getFileNameCheck(String uploadRealPath, String originalFilename) {
	    int index = 1;
	    String newFilename = originalFilename;

	    while (true) {
	        File file = new File(uploadRealPath, newFilename);
	        if (!file.exists()) {
	            return newFilename; // 파일이 없으면 현재 이름 반환
	        }

	        // 파일명이 중복되면 숫자 추가 (ex: file-1.txt, file-2.txt)
	        String baseName = originalFilename.substring(0, originalFilename.lastIndexOf('.'));
	        String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
	        newFilename = baseName + "-" + index + extension;

	        index++;
	    }
	}
	
	// 상품을 등록...
	@PostMapping(value = "/prdAdd.htm", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String addProduct(
	    @ModelAttribute ProductDTO product, // 상품 데이터
	    @RequestParam("file1") MultipartFile multipartFile1, // 파일1
	    @RequestParam("file2") MultipartFile multipartFile2, // 파일2
	    HttpServletRequest request,
	    RedirectAttributes redirectAttributes
	) {
	    try {
	        // 실제 파일 저장 경로 설정
	        String uploadRealPath = "C:\\upload";
	        System.out.println("Upload Real Path: " + uploadRealPath);

	        // 업로드 디렉토리가 없으면 생성
	        File uploadDir = new File(uploadRealPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdirs();
	        }

	        // 파일 업로드 처리
	        if (multipartFile1 != null && !multipartFile1.isEmpty()) {
	            String originalFilename1 = multipartFile1.getOriginalFilename();
	            String filesystemName1 = getFileNameCheck(uploadRealPath, originalFilename1);
	            File dest1 = new File(uploadRealPath, filesystemName1);
	            multipartFile1.transferTo(dest1); // 파일 저장
	            product.setPdtImgUrl(filesystemName1); // DTO에 파일 이름 설정
	        }

	        if (multipartFile2 != null && !multipartFile2.isEmpty()) {
	            String originalFilename2 = multipartFile2.getOriginalFilename();
	            String filesystemName2 = getFileNameCheck(uploadRealPath, originalFilename2);
	            File dest2 = new File(uploadRealPath, filesystemName2);
	            multipartFile2.transferTo(dest2); // 파일 저장
	            product.setPdtImgUrl2(filesystemName2); // DTO에 파일 이름 설정
	        }

	        // 상품 추가 로직
	        int result = productService.addProduct(product);
	        if (result > 0) {
	            redirectAttributes.addFlashAttribute("message", "상품이 성공적으로 추가되었습니다.");
	        } else {
	            redirectAttributes.addFlashAttribute("message", "상품 추가에 실패했습니다.");
	        }
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("message", "상품 추가 중 오류가 발생했습니다.");
	        e.printStackTrace();
	    }

	    return "redirect:/prdList.htm"; // 리다이렉트
	}


    
}
