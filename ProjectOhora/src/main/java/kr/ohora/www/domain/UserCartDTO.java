package kr.ohora.www.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCartDTO {
	
	private String pdtName; // 상품 이름
	private int pdtAmount; // 상품 가격
	private int clistPdtCount; // 상품 수량
	private String clistSelect; // 상품 체크 여부
	private int pdtId; // 상품 id
	private String pdtImgUrl; // 이미지 경로
	private int pdtDiscountRate; // 할인율
	private int optId; // 옵션 id
	private int clistId; // 장바구니 id
	
} // class
