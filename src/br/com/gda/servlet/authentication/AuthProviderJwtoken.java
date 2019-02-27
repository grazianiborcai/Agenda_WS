package br.com.gda.servlet.authentication;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public final class AuthProviderJwtoken implements AuthenticationProvider {
	
	@Override public Authentication authenticate(Authentication authentication) throws AuthenticationException {        
        if (authentication == null)
        	onError();
        
        if (authentication.getAuthorities() == null)
        	onError();
        
        if (authentication.getAuthorities().isEmpty())
        	onError();
        
        if (authentication.getPrincipal() == null)
        	onError();
		
        
		return authentication;
	}
	
	
	
	private void onError() throws AuthenticationException {
		throw new AuthenticationCredentialsNotFoundException("Invalid Credentials!");	//TODO: melhorar mensagem
	}

	
	
	@Override public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
