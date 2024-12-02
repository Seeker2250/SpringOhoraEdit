package kr.ohora.www.domain;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
	
	private int userId; //회원번호
	private int memId; //회원등급
	private int authId; //회원권한 (1 관리 2 회원)
	private String userLoginId;
	private String userPassword;
	private String userName;
	private String userEmail;
	private String userTel;
	private Date userBirth;
	private int userPoint;
	private char userSmsAgree;
	private Date userJoindate;
	private char userEmailAgree;
	
	// 추가
	private boolean enabled;
	private List<AuthVO> authList;
	
} // class
