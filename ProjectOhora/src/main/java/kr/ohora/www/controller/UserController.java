package kr.ohora.www.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ohora.www.domain.UserDTO;
import kr.ohora.www.persistence.UserMapper;
import kr.ohora.www.service.UserService;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j

@RequestMapping("/user/*")
public class UserController {
   
   @Autowired
   private UserService userService;
   
    @Autowired
     private PasswordEncoder passwordEncoder;
   
   // 회원가입 창 /user/join.htm -> /user/oho_join.jsp
   @GetMapping("/join.htm")
    public String join() {
       log.info("JoinController test");
        return "oho_join"; // 회원가입 페이지로 이동
    }
   
   // 회원가입 창 /user/join.htm + POST  -> home2 응답
    @PostMapping("/join.htm")
      public String join( Model model, UserDTO dto) throws Exception{
       log.info("JoinController test1");
       
       String encryptedPassword = passwordEncoder.encode(dto.getUserPassword());
       dto.setUserPassword(encryptedPassword); 
       log.info("@@@@@@@@@@@@@" + encryptedPassword);
       
       log.info("JoinController test2");
         Integer successJoin = this.userService.join(dto);
         log.info("JoinController test3");
         if (successJoin  > 0) {
         } // if
         if (successJoin > 0) {
            model.addAttribute("successJoin", successJoin);
            return "oho_joinOk";
         } else {
            return "oho_joinError";
         } // if else
      } // join
      
   
   
} // class