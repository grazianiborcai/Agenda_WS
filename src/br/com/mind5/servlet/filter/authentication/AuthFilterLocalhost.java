package br.com.mind5.servlet.filter.authentication;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public final class AuthFilterLocalhost extends BasicAuthenticationFilter {
    private static String LOCALHOST_IPV6_A = "[0:0:0:0:0:0:0:1]";
    private static String LOCALHOST_IPV6_B = "0:0:0:0:0:0:0:1";
    private static String LOCALHOST_IPV6_C = "[::1]";
    private static String LOCALHOST_IPV4   = "127.0.0.1";
    
	
	public AuthFilterLocalhost(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
		super(authenticationManager, authenticationEntryPoint);
	}
	
	
	
	public AuthFilterLocalhost(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	
	
	@Override protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {        
		String remoteAddr = req.getRemoteAddr();
		
		if (isLocalhost(remoteAddr) == false) {
        	res = onError(res);
            return;
		}
		
		chain.doFilter(req, res);
    }
	
	
	
	private boolean isLocalhost(String remoteAddr) {
		if (remoteAddr == null)
			return false;
		
		if (remoteAddr.equals(LOCALHOST_IPV4) 	||
			remoteAddr.equals(LOCALHOST_IPV6_A) ||
			remoteAddr.equals(LOCALHOST_IPV6_B) ||
			remoteAddr.equals(LOCALHOST_IPV6_C) 	)
			return true;
		
		return false;
	}
	
	
	
    private HttpServletResponse onError(HttpServletResponse res) throws IOException {
    	((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED);	//TODO: melhorar resposta
    	return res;
    }
}
