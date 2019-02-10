package br.com.gda.servlet.authUser;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public final class AuthToken extends UsernamePasswordAuthenticationToken {
	private static final long serialVersionUID = 1L;
	private String owner;
	private String uri;
	
	
	public AuthToken(Object principal, Object credentials, String hdrOwner, String hdrUri) {
		super(principal, credentials);
		super.setAuthenticated(false);
		init(hdrOwner, hdrUri);
	}
	
	
	
    public AuthToken(Object principal, Object credentials, String hdrOwner, String hdrUri, Collection<? extends GrantedAuthority> authorities) {
            super(principal, credentials, authorities);
            super.setAuthenticated(true);
            init(hdrOwner, hdrUri);
    }
    
    
    
    private void init(String hdrOwner, String hdrUri) {
		owner = hdrOwner;
		uri = hdrUri;
    }
    
    
    
    public String getOwner() {
    	return owner;
    }
    
    
    
    public String getUri() {
    	return uri;
    }
	
	
/*	
	private long parseOwner(String strOwner) {
		try {		
			if (strOwner == null)
				return DefaultValue.number();
			
			return Long.valueOf(strOwner);
			
		
		} catch(NumberFormatException e) {
			return Long.valueOf(strOwner);
		}
	}
*/
}
