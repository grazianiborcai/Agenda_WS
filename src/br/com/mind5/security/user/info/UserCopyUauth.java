package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.userAuthentication.info.UauthInfo;

final class UserCopyUauth extends InfoCopierTemplate<UserInfo, UauthInfo>{
	
	public UserCopyUauth() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(UauthInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
