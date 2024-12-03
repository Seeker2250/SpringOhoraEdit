package kr.ohora.www.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.ohora.www.domain.AddressDTO;
import kr.ohora.www.domain.MyPageDTO;
import kr.ohora.www.domain.OrderDetailDTO;
import kr.ohora.www.domain.UserDTO;

public interface UserService {

	// 회원 가입 및 회원가입 완료
	public Integer join(UserDTO dto) throws SQLException;

	// 중복 체크
	public Integer jungbokCK(UserDTO dto) throws SQLException;

	// 아이디 찾기
	public UserDTO findUser(UserDTO dto) throws SQLException;

	// 비밀번호 찾기
	public UserDTO findPwd(UserDTO dto) throws SQLException;

	// 비밀번호 변경
	public Integer changePwd(UserDTO dto) throws SQLException;


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

	// 리뷰 썼는지 여부 체크 (준용)
	public int rvck(int opdtId);
	
} // interface