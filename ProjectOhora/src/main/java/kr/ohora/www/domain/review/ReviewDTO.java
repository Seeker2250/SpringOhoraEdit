package kr.ohora.www.domain.review;

import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
	private int revId;
	private int userId;
	private int ordPk;
	private int opdtId;  //주문상세번호
	private String revContent;
	private Date revWritedate;
	private int revRating;
	private int revGoodCount;
	private int revBadCount;
	private int revCommentCount;
	private String revIsrecommend;
	private String revIsphoto;
	private String revAgeGroup;
	private String revOption; //구매상품 옵션
	private int pdtId;
	private String userName;
	
	private boolean newImg; // 컬럼 추가
	private int mediacount;
	
//	미디어를 위한
	ArrayList<RevMedia>  revMediaList;

	private int mediaCnt;

}
