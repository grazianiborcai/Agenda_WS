package br.com.gda.servlet.authUser;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public final class AuthToken extends UsernamePasswordAuthenticationToken {
	private static final long serialVersionUID = 1L;
	private String owner;
	private String uri;
	
	
	public AuthToken(Object principal, Object credentials, String owner, String uri) {
		super(principal, credentials);
		super.setAuthenticated(false);
		init(owner, uri);
	}
	
	
	
    public AuthToken(Object principal, Object credentials, String owner, String uri, Collection<? extends GrantedAuthority> authorities) {
            super(principal, credentials, authorities);
            super.setAuthenticated(true);
            init(owner, uri);
    }
    
    
    
    private void init(String owner, String uri) {
		this.owner = owner;
		this.uri = uri;
    }
    
    
    
    public String getOwner() {
    	return owner;
    }
    
    
    
    public String getUri() {
    	return uri;
    }
}
