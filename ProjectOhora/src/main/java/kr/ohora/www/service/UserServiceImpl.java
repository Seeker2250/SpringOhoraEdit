package kr.ohora.www.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ohora.www.domain.AddressDTO;
import kr.ohora.www.domain.MyPageDTO;
import kr.ohora.www.domain.OrderDetailDTO;
import kr.ohora.www.domain.UserDTO;
import kr.ohora.www.persistence.UserMapper;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class UserServiceImpl implements UserService {

   @Autowired
   private UserMapper userDao;
   
   // 회원가입
   @Override
   public Integer join(UserDTO dto) throws SQLException {
      log.info("joinServiceImpl test");
      
      return this.userDao.join(dto);
   }

   // 회원 장바구니 수 select
	@Override
	public int pdtCountSelect(int userId) {
		log.info("pdtCountSelect test");
		return this.userDao.pdtCountSelect(userId);
	}
	
	// 마이페이지 addrCount select
	@Override
	public List<MyPageDTO> myPageAddrCount(int userId) {
		log.info("myPageAddrCount test");
		return this.userDao.myPageAddrCount(userId);
	}
	
	// 마이페이지 orderList select
	@Override
	public List<MyPageDTO> myPageOrdList(int userId) {
		log.info("myPageOrdList test");
		return this.userDao.myPageOrdList(userId);
	}
	
	// orderDetail topList select
	@Override
	public List<OrderDetailDTO> topList(int userId, int ordPk) {
		log.info("topList test");
		return this.userDao.topList(userId, ordPk);
	}
	
	// orderDetail orderList select
	@Override
	public List<OrderDetailDTO> orderList(int userId, int opdtId) {
		log.info("orderList test");
		return this.userDao.orderList(userId, opdtId);
	}
	
	// orderDetail orderList2 select
	@Override
	public List<OrderDetailDTO> orderList2(String opdtName) {
		log.info("orderList2 test");
		return this.userDao.orderList2(opdtName);
	}
	
	// orderDetail addrList
	@Override
	public List<OrderDetailDTO> addrList(int userId) {
		log.info("addrList test");
		return this.userDao.addrList(userId);
	}
	
	// 배송주소록 select
	@Override
	public List<AddressDTO> addrSelect(int userId) {
		log.info("addrSelect test");
		return this.userDao.addrSelect(userId);
	}
	
	// 배송주소록 기본 배송지 변경
	@Override
	@Transactional
	public int mainChange(int userId, int addrId) {
		
		int allChange = this.userDao.allChange(userId);
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + allChange);
		int mainChange = this.userDao.mainChange(addrId);
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + mainChange);
		
		return allChange + mainChange;
	}
	
	// 배송지 삭제
	@Override
	public int addrDelete(List<Integer> addrId) {
		log.info("addrDelete test");
		return this.userDao.addrDelete(addrId);
	}
  
   
   // 회원가입 중복체크
   @Override
   public boolean jungbokCK(String id, String email, String phone) throws SQLException {
      log.info("joinServiceImpl test");
      
      return false;
   }
	
   //주소지 등록 (준용)
	@Override
	public void insertAddr(int userId, String locationName, String receiverName, String zipCode, String addr1, String addr2,
			String mobile) {
		this.userDao.insertAddr(userId, locationName, receiverName, zipCode, addr1, addr2, mobile);
		
	} 
   

   
   
} // class