package kr.ohora.www.persistence;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;

import kr.ohora.www.domain.UserDTO;

public interface UserMapper {
	
	// 로그인 처리
	public UserDTO login( @Param("id") String id ) throws SQLException;
	
	// 회원 가입
	   public Integer join(UserDTO dto) throws SQLException;
	   
	   //회원가입 페이지 아이디 이메일 폰번호 중복체크
	   public boolean jungbokCK(@Param("id") String id, @Param("email") String email, @Param("phone") String phone) throws SQLException;
	
} // interface