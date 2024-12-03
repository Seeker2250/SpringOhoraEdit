package kr.ohora.www.persistence;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.ohora.www.domain.AddressDTO;
import kr.ohora.www.domain.MyPageDTO;
import kr.ohora.www.domain.OrderDetailDTO;
import kr.ohora.www.domain.UserDTO;

public interface UserMapper {

	// 회원 가입
	public Integer join(UserDTO dto) throws SQLException;

	// 로그인 처리
	public UserDTO login( @Param("id") String id ) throws SQLException;

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

	// 배송지 all 변경
	public int allChange(int userId);

	// 배송지 메인 변경
	public int mainChange(int addrId);

	// 배송지 삭제
	public int addrDelete(List<Integer> addrId);

	//주소 추가 (준용)
	void insertAddr(
			@Param("userId") int userId,
			@Param("locationName") String locationName,
			@Param("receiverName") String receiverName,
			@Param("zipCode") String zipCode,
			@Param("addr1") String addr1,
			@Param("addr2") String addr2,
			@Param("mobile") String mobile
			);

	// 리뷰 썼는지 체크 (준용)
	public int rvCheck(int opdtId);

} // interface