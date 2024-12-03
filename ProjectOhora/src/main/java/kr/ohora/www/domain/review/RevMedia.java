package kr.ohora.www.domain.review;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RevMedia {
	private int revId ;
	private String  filesystemname;
	private String fileoriginalname;
	
	//리뷰 이미지 파일들 업로드
	private List<CommonsMultipartFile> attach;

}
