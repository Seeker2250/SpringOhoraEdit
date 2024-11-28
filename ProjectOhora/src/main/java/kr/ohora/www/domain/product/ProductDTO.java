package kr.ohora.www.domain.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductDTO {

    private int pdtId; // pdt_id -> pdtId
    private String pdtName; // pdt_name -> pdtName
    private int pdtAmount; // pdt_amount -> pdtAmount
    private int pdtDiscountRate; // pdt_discount_rate -> pdtDiscountRate
    private String pdtImgUrl; // pdt_img_url -> pdtImgUrl
    private String pdtImgUrl2; // pdt_img_url2 -> pdtImgUrl2
    private int pdtReviewCount; // pdt_review_count -> pdtReviewCount
    private int pdtSalesCount; // pdt_sales_count -> pdtSalesCount
    private int catId; // cat_id -> catId
    private String pdtDescription; // pdt_description -> pdtDescription
    private int pdtDiscountAmount; // pdt_discount_amount -> pdtDiscountAmount
    private int pdtViewcount; // pdt_viewcount -> pdtViewcount

    // 옵션 관련 필드: 여러 옵션을 포함할 수 있도록 List로 설정
    private List<OptionDTO> options;

    // 옵션 존재 여부
    public boolean hasOptions() {
        return options != null && !options.isEmpty();
    }

    private int scatId; // scat_id -> scatId
    private int pdtNumber; // pdt_number -> pdtNumber
    private int pdtCount; // pdt_count -> pdtCount

    private Date pdtAdddate; // pdt_adddate -> pdtAdddate

    private int optId; // opt_id -> optId
    private String optName; // opt_name -> optName
    private int optAmount; // opt_amount -> optAmount
    private int optCount; // opt_count -> optCount
}
