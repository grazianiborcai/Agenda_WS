package br.com.mind5.servlet.filter.authentication;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public final class AuthProviderLocalhost implements AuthenticationProvider {
	
	@Override public Authentication authenticate(Authentication authentication) throws AuthenticationException {  
		return authentication;
	}

	
	
	@Override public boolean supports(Class<?> authentication) {
		return true;
	}
}
