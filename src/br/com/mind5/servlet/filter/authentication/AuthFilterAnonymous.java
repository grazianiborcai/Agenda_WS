package br.com.mind5.servlet.filter.authentication;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public final class AuthFilterAnonymous extends BasicAuthenticationFilter {
    
	
	public AuthFilterAnonymous(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
		super(authenticationManager, authenticationEntryPoint);
	}
	
	
	
	public AuthFilterAnonymous(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	
	
	@Override protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {  
		//Custom logic
		chain.doFilter(req, res);
    }
}
