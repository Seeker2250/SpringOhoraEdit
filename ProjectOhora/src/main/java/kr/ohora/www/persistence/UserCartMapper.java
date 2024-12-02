package kr.ohora.www.persistence;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.ohora.www.domain.UserCartDTO;
import kr.ohora.www.domain.UserDTO;

public interface UserCartMapper {
	
	// 회원 장바구니 select
	public List<UserCartDTO> UserCartSelect(int userId) throws SQLException;
	
	// 회원 장바구니 수량 감소
	public int userCartMinusBtn (@Param("clistId") int clistId, @Param("clistPdtCount") int clistPdtCount) throws SQLException;
	
	// 회원 장바구니 수량 증가
	public int userCartPlusBtn(int clistId) throws SQLException;
	
	// 회원 장바구니 상품 삭제
	public int userCartDelBtn(int clistId) throws SQLException;
	
	// 회원 장바구니 check
	public Integer userCartCheck(@Param("userId") int userId, @Param("pdtId") int pdtId);
	
	// 회원 장바구니 insert
	public int userCartAddCartInsert(@Param("userId") int userId, @Param("pdtId") int pdtId);
	
	// 회원 장바구니 CountUp
	public int userCartAddCartCountUp(@Param("userId") int userId, @Param("pdtId") int pdtId);
	
} // interface
