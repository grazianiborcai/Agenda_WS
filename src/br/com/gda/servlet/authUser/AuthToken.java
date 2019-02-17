package br.com.gda.servlet.authUser;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import br.com.gda.common.DefaultValue;

public final class AuthToken extends UsernamePasswordAuthenticationToken {
	private static final long serialVersionUID = 1L;
	private long codOwner;
	private String codLanguage;
	
	
	public AuthToken(Object principal, Object credentials, String owner, String language) {
		super(principal, credentials);
		super.setAuthenticated(false);
		initOwner(owner);
		initLanguage(language);
	}
	
	
	
    public AuthToken(Object principal, Object credentials, String owner, String language, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        super.setAuthenticated(true);
        initOwner(owner);
        initLanguage(language);
    }
    
    
    
    private void initOwner(String owner) {
		try {
	    	if (owner == null) {
				codOwner = DefaultValue.number();
	    	} else {	    	
	    		codOwner = Long.valueOf(owner);
	    	}
		
		} catch (NumberFormatException e) {
			codOwner = DefaultValue.number();
		}
    }
    
    
    
    private void initLanguage(String language) {
    	if (language == null) {
    		codLanguage = DefaultValue.language();
    	} else {
    		codLanguage = language;
    	}
    }
    
    
    
    public long getCodOwner() {
    	return codOwner;
    }
    
    
    
    public String getCodLanguage() {
    	return codLanguage;
    }
}
