package kr.ohora.www.domain.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductDTO {

	private Integer pdtId; // Integer로 변경 -> 기본값 null
    private String pdtName; // 필수 입력 필드
    private Integer pdtAmount; // Integer로 변경 -> 기본값 null
    private int pdtDiscountRate; 
    private String pdtImgUrl = ""; // 빈 문자열 유지
    private String pdtImgUrl2 = ""; // 빈 문자열 유지
    private int pdtReviewCount; 
    private int pdtSalesCount; 
    private Integer catId; // Integer로 변경 -> 기본값 null
    private String pdtDescription = ""; // 빈 문자열 유지
    private Integer pdtDiscountAmount; // Integer로 변경 -> 기본값 null
    private int pdtViewcount; //  기본값 0

    // 옵션 필드
    private List<OptionDTO> options = new ArrayList<>();
    public boolean hasOptions() {
        return options != null && options.size() > 0;
    }

    private Integer scatId; // Integer로 변경 -> 기본값 null
    private Long ordPk;// pk 넣어
    private Integer pdtNumber; // Integer로 변경 -> 기본값 null
    private int pdtCount; 

    private Date pdtAdddate = new Date(); // 기본값 현재 날짜

    private Integer optId; // Integer로 변경 -> 기본값 null
    private String optName = ""; // 빈 문자열 유지
    private Integer optAmount; // Integer로 변경 -> 기본값 null
    private Integer optCount; // Integer로 변경 -> 기본값 null

    private MultipartFile file1;
    private MultipartFile file2;
    
    //private CommonsMultipartFile file1; // 이미지 파일1
    //private CommonsMultipartFile file2; // 이미지 파일2
    
    public int getProductId() {
        return this.pdtId;
    }
}
