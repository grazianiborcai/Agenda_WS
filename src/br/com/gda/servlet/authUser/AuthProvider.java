package br.com.gda.servlet.authUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public final class AuthProvider implements AuthenticationProvider {

	
	@Override public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("MBM_02"));
        
        return new UsernamePasswordAuthenticationToken(name, password, roles);
	}

	
	
	@Override public boolean supports(Class<?> authentication) {
		return authentication.equals(AuthToken.class);
	}
}
