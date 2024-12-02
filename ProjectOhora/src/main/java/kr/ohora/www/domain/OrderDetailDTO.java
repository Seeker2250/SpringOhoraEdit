package kr.ohora.www.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDTO {
	
	private String ordId;
	private Date ordOrderdate;
	private String ordName;
	private String opdtState;
	private int ordTotalAmount;
	private int discount;
	private int amount;
	private String ordPayOption;
	//
	private String opdtName;
	private int opdtCount;
	private String pdtImgUrl;
	private String pdtName;
	private int pdtAmount;
	private int discountPrice;
	//
	private String addrName;
    private String addrZipcode;
    private String addrAddressMain;
    private String addrHtel;
    private String addrTel;
	
} // class