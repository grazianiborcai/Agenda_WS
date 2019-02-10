package br.com.gda.servlet.authUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public final class AuthFilter extends UsernamePasswordAuthenticationFilter {
	//private static final String OWNER = "codOwner";
	private static final String PASSWORD = "password";
	private static final String USER_NAME = "username";
	

	@Override public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		UsernamePasswordAuthenticationToken authRequest = getAuthRequest(request);
		setDetails(request, authRequest);
		
		return this.getAuthenticationManager().authenticate(authRequest);
	}
	
	
	
	private UsernamePasswordAuthenticationToken getAuthRequest(HttpServletRequest request) {
		//String owner = getOwner(request);
		String username = getUsername(request);
		String password = getPassword(request);
		//String uri = getUri(request);
		/*
		StringBuilder ownerUserUri = new StringBuilder();
		ownerUserUri.append(owner);
		ownerUserUri.append(AuthUserDetail.SEPARATOR);
		ownerUserUri.append(username);
		ownerUserUri.append(AuthUserDetail.SEPARATOR);
		ownerUserUri.append(uri);
		*/
		
		return new UsernamePasswordAuthenticationToken(username, password);
	}
	
	
	/*
	private String getOwner(HttpServletRequest request) {			
		return request.getHeader(OWNER).trim();
	}*/
	
	
	
	private String getUsername(HttpServletRequest request) {
		return request.getHeader(USER_NAME).trim();
	}
	
	
	
	private String getPassword(HttpServletRequest request) {
		return request.getHeader(PASSWORD);
	}
	
	
	/*
	private String getUri(HttpServletRequest request) {
		return request.getContextPath(); 
	}*/
}
