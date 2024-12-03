package kr.ohora.www.domain.order;

import java.util.List;

import kr.ohora.www.domain.product.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {/*
   private Integer ordPk;
   private String ordId;
   private String rname;
   private String rzipcode1;
   private String raddr1;
   private String raddr2; 
   
   private String rphone2_1;
   private String rphone2_2;
   private String rphone2_3;
   private String email1;
   private String addrPaymethod;
   private List<String> pdtName;
   private List<Integer> pdtCount;
   private List<Integer> pdtAmount;
   private List<Integer> pdtDcAmount;
   private List<Integer> pdtId;
   private int totalSum;//원가 총합
   private int discountSum;//할인가 총합
   private int inputPoint = 0;
   private int icpnId = 0;
   private int icpnDc = 0;
   private int userId;
   private int deliveryFee;
   private String phone;      // 합쳐진 전화번호
   private String address;    // 합쳐진 주소*/
	
	
	   private Long ordPk;
	    private String ordId;
	    private String rname;
	    private String rzipcode1;
	    private String raddr1;
	    private String raddr2; 
	    
	    private String rphone2_1;
	    private String rphone2_2;
	    private String rphone2_3;
	    private String email1;
	    private String addrPaymethod;
	    
	    // 상품 리스트로 변경
	    private List<ProductDTO> products;
	    
	    private int totalSum; // 원가 총합
	    private int discountSum; // 할인가 총합
	    private int inputPoint = 0;
	    private int icpnId = 0;
	    private int icpnDc = 0;
	    private int userId;
	    private int deliveryFee;
	    private String phone;      // 합쳐진 전화번호
	    private String address;    // 합쳐진 주소
}
