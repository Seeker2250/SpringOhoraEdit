package kr.ohora.www.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ohora.www.domain.UserCartDTO;
import kr.ohora.www.domain.UserDTO;
import kr.ohora.www.persistence.UserCartMapper;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class UserCartServiceImpl implements UserCartService{
	
	@Autowired
	private UserCartMapper userCartMapper;
	
	// 회원 장바구니 select
	@Override
	public List<UserCartDTO> userCartSelect(int userId) throws SQLException {
		log.info("userCartSelect test");
		return this.userCartMapper.UserCartSelect(userId);
	}
	
	// 회원 장바구니 수량 감소
	@Override
	public int userCartMinusBtn(int clistId, int clistPdtCount) throws SQLException {
		log.info("userCartMinusBtn test");
		return this.userCartMapper.userCartMinusBtn(clistId, clistPdtCount);
	}
	
	// 회원 장바구니 수량 증가
	@Override
	public int userCartPlusBtn(int clistId) throws SQLException {
		log.info("userCartPlusBtn test");
		return this.userCartMapper.userCartPlusBtn(clistId);
	}
	
	// 회원 장바구니 상품 삭제
	@Override
	public int userCartDelBtn(int clistId) throws SQLException {
		log.info("userCartDelBtn test");
		return this.userCartMapper.userCartDelBtn(clistId);
	}
	
	// 회원 장바구니 check
	@Override
	public Integer userCartCheck(int userId, int pdtId) {
		log.info("userCartCheck test");
		return this.userCartMapper.userCartCheck(userId, pdtId);
	}
	
	// 회원 장바구니 insert
	@Override
	public int userCartAddCartInsert(int userId, int pdtId) {
		log.info("userCartAddCartInsert test");
		return this.userCartMapper.userCartAddCartInsert(userId, pdtId);
	}
	
	// 회원 장바구니 CountUp
	@Override
	public int userCartAddCartCountUp(int userId, int pdtId) {
		log.info("userCartAddCartCountUp test");
		return this.userCartMapper.userCartAddCartCountUp(userId, pdtId);
	}
	
} // class