package kr.ohora.www.domain.security;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.ohora.www.domain.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
public class CustomerUser extends User {
    
    private UserDTO user; // 모든 사용자 정보
    
    public CustomerUser(String username, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
    
    public CustomerUser(UserDTO user) {
    	super(user.getUserLoginId()
    			, user.getUserPassword()
    			, user.getAuthList().stream()
    			.map( auth->new SimpleGrantedAuthority(auth.getAuthName()) )
    			.collect(Collectors.toList()));
    	
    	this.user = user;
    }
    
} // class