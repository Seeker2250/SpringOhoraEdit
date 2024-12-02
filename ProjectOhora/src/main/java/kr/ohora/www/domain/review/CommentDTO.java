package kr.ohora.www.domain.review;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
	private int cmtId;
	private int revId;
	private int userId;
	private Date cmtWritedate;
	private String cmtContent;
	
	private String userName;

}
