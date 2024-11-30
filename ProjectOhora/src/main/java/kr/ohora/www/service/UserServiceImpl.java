package kr.ohora.www.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

   // 회원가입 중복체크
   @Override
   public boolean jungbokCK(String id, String email, String phone) throws SQLException {
      log.info("joinServiceImpl test");
      
      return false;
   } 
   

   
   
} // class