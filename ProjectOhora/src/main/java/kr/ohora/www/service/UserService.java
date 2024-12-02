package kr.ohora.www.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.ohora.www.domain.AddressDTO;
import kr.ohora.www.domain.MyPageDTO;
import kr.ohora.www.domain.OrderDetailDTO;
import kr.ohora.www.domain.UserDTO;

public interface UserService {

	// 회원 가입
	public Integer join(UserDTO dto) throws SQLException;

	//회원가입 페이지 아이디 이메일 폰번호 중복체크
	public boolean jungbokCK(@Param("id") String id, @Param("email") String email, @Param("phone") String phone) throws SQLException;


	// 회원 장바구니 수 select
	public int pdtCountSelect(int userId);

	// 마이페이지 addrCount select
	public List<MyPageDTO> myPageAddrCount(int userId);

	// 마이페이지 orderList select
	public List<MyPageDTO> myPageOrdList(int userId);

	// ordDetail topList select
	public List<OrderDetailDTO> topList(@Param("userId") int userId, @Param("ordPk") int ordPk);

	// ordDetail orderList select
	public List<OrderDetailDTO> orderList(@Param("userId") int userId, @Param("opdtId") int opdtId);

	// ordDetail orderList2 select
	public List<OrderDetailDTO> orderList2(String opdtName);

	// ordDetail addrList select
	public List<OrderDetailDTO> addrList(int userId);

	// 배송주소록 select
	public List<AddressDTO> addrSelect(int userId);

	// 배송주소록 기본 배송지 변경
	public int mainChange(@Param("userId") int userId, @Param("addrId") int addrId);

	// 배송지 삭제
	public int addrDelete(List<Integer> addrId);



	//주소지 등록 (준용)
	void insertAddr(
			@Param("userId") int userId, 
			@Param("locationName") String locationName, 
			@Param("receiverName") String receiverName, 
			@Param("zipCode") String zipCode, 
			@Param("addr1") String addr1, 
			@Param("addr2") String addr2, 
			@Param("mobile") String mobile
			)throws SQLException;


} // interface