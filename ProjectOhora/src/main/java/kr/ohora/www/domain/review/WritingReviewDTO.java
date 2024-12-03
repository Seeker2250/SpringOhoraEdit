package kr.ohora.www.domain.review;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WritingReviewDTO {
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

	
	private String  filesystemname;
	private String fileoriginalname;
	
	//리뷰 이미지 파일들 업로드
	private List<CommonsMultipartFile> attach;


}
