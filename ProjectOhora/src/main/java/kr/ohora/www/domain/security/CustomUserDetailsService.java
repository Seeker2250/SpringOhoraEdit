package kr.ohora.www.domain.security;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import kr.ohora.www.domain.UserDTO;
import kr.ohora.www.persistence.UserMapper;
import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO dto = null;
        
        try {
			dto = this.userDao.login(username);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} // try catch
        
        return dto == null ? null : new CustomerUser(dto);
    }
	
} // class