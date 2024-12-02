package kr.ohora.www.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDTO {
	
	int addrId; // 주소 id
	int userId;
	private String addrNick; // 예) 학원, 집
	private String addrName; // 이름
	private String addrHtel; // 집 번호
	private String addrTel; // 휴대폰 번호
    private String addrAddressMain;  // 주소
    private String addrAddressDetail; // 상세 주소
    private String addrZipcode; // 우편번호
    private String addrMain; // 메인으로 쓰일 주소 Y / N
	
} // class