package kr.ohora.www.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component("customLoginSuccessHandler")
@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		log.warn("login Success test");
		
		List<String> roleNames = new ArrayList<String>();
		
		authentication.getAuthorities().forEach( auth -> {
			roleNames.add(auth.getAuthority());
		});
		
		if (roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/auth.htm");
			return;
		} else if (roleNames.contains("ROLE_USER")) {
			response.sendRedirect("/pdtCount.htm"); // 메인페이지로 바꿔야된다.
			return;
		} // if
		
	} //
	
} // class