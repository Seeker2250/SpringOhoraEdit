package kr.ohora.www.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
   private String orderId;
   private String rname;
   private String rzipcode1;
   private String raddr1;
   private String raddr2;
   private String rphone2_1;
   private String rphone2_2;
   private String rphone2_3;
   private String email1;
   private String addrPaymethod;
   private String[] pdtName;
   private int[] pdtCount;
   private int[] pdtAmount;
   private int[] pdtDcAmount;
   private int[] pdtId;
   private int totalSum;//원가 총합
   private int discountSum;//할인가 총합
   private int inputPoint = 0;
   private int icpnId = 0;
   private int icpnDc = 0;
   private int userId;
   private int deliveryFee;
   private String phone;      // 합쳐진 전화번호
   private String address;    // 합쳐진 주소
}
