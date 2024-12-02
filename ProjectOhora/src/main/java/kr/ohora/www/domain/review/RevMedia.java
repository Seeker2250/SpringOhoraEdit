package kr.ohora.www.domain.review;

import java.util.Date;

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

}
