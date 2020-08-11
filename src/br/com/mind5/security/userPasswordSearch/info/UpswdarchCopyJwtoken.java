package br.com.mind5.security.userPasswordSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

final class UpswdarchCopyJwtoken extends InfoCopierTemplate<UpswdarchInfo, JwtokenInfo> {
	
	public UpswdarchCopyJwtoken() {
		super();
	} 
	
	
	
	@Override protected UpswdarchInfo makeCopyHook(JwtokenInfo source) {
		UpswdarchInfo result = new UpswdarchInfo();		
		
		result.codOwner = source.codOwner;
		result.username = source.username;	
		result.lastChanged = source.createdOn;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
