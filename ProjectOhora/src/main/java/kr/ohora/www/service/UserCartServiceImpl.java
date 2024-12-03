package kr.ohora.www.service;

import java.sql.SQLException;
import java.util.ArrayList;
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
	
		// 회원 상세 페이지 장바구니 담기
		@Override
		public Integer addCartBtn(int userId, List<Integer> pdtId, List<Integer> pdtCount) {
		    log.info("addCartBtn test");

		    // 빈 리스트로 초기화
		    List<Integer> AllCheck = new ArrayList<>();
		    
		    // 각 제품 ID와 수량에 대해 처리
		    for (int i = 0; i < pdtId.size(); i++) {
		        Integer pdtId1 = pdtId.get(i);
		        Integer pdtCount1 = pdtCount.get(i);

		        // 장바구니에 해당 제품이 있는지 확인
		        Integer check = this.userCartMapper.addBtnCheck(userId, pdtId1);
		        AllCheck.add(check != null ? check : 0); // null을 0으로 대체

		        log.info("@@@@@@@@@@@@@@@@@@@@ AllCheck: " + AllCheck);
		    }

		    int totalRowCount = 0;  // 전체 인서트된 수를 추적하는 변수
		    
		    // AllCheck 리스트를 순회하면서 처리
		    for (int i = 0; i < AllCheck.size(); i++) {
		        if (AllCheck.get(i) == 0) {
		            // 장바구니에 없는 경우, 새로운 제품을 추가
		            Integer rowCount = this.userCartMapper.addBtnInsert(userId, pdtId.get(i), pdtCount.get(i));
		            if (rowCount == 1) {
		                totalRowCount += 1;  // 성공적으로 추가된 인서트 수를 누적
		            }
		        } else {
		            // 장바구니에 이미 있는 경우, 수량을 업데이트
		            this.userCartMapper.addBtnUpdate(userId, pdtId.get(i), pdtCount.get(i));
		        }
		    }

		    // 하나 이상의 인서트가 되었으면 누적된 totalRowCount 반환
		    return totalRowCount > 0 ? totalRowCount : null;  // 0이면 null을 반환 (업데이트만 한 경우)
		}
	
} // class