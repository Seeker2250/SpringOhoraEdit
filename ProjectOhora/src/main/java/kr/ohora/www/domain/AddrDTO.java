package kr.ohora.www.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddrDTO {

   private int addrId;
   private int userId;
   private String addrNick;
   private String addrName;
   private String addrHtel;
   private String addrTel;         // 휴대전화
   private String addrAddressMain; // 기본 주소
   private String addrAddressDetail; // 나머지 주소
   private String addrZipcode;
   private String addrMain;       // 대표 배송지 (기본값 'N')
}
