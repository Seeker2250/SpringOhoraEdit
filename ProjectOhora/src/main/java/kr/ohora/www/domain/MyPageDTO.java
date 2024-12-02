package kr.ohora.www.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyPageDTO {
	
	private String userName; // 회원 이름
	private String memName; // 멤버십명
	private int userPoint; // 적립금
	private String opdtState; // 주문처리상태
    private String orderStatus;  // 주문 상태 필드
    private Date ordOrderdate; // 주문일
    private String opdtName; // 상품명
    private int opdtAmount; // 주문상품 가격
    // 추가
    private int opdtId;
    private int ordPk; // pk
	
} // class
