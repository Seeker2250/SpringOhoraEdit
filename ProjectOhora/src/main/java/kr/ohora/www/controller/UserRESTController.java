package kr.ohora.www.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.ohora.www.domain.UserDTO;
import kr.ohora.www.service.UserService;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/ajax/*")
public class UserRESTController {

    @Autowired
    private UserService userService;

    // 중복 체크 
    @GetMapping(value = "/jungbokCK.ajax")
    public Integer jungbokCK(@RequestParam("msgTag") String msgTag, 
    		@RequestParam("val") String value) throws SQLException {
        log.info("중복 체크 요청 받음");

        UserDTO dto = new UserDTO();
        
        
        if ( msgTag.equals("idMsg") ) {
			dto.setUserLoginId(value);
			System.out.println("DTO@@@@@@@@@@@@ USER :::" + dto.getUserLoginId());
			
		} else if ( msgTag.equals("emailMsg")) {
			dto.setUserEmail(value);
			System.out.println("DTO@@@@@@@@@@@@ USER :::" + dto.getUserEmail());
			
		} else { //폰
			dto.setUserTel(value);
			System.out.println("DTO@@@@@@@@@@@@ USER :::" + dto.getUserTel());
			
		}
        
        
        try {
            // 중복 체크 메서드 호출
            Integer isDuplicated = this.userService.jungbokCK(dto);
            log.info("> 중복 체크 결과: " + isDuplicated);

            return isDuplicated;
        } catch (SQLException e) {
            log.error("Database error 발생", e); // 예외 발생 시 에러 로그
         
        }
		return 1;
    }
}
