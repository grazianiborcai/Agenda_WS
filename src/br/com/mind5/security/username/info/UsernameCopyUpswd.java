package br.com.mind5.security.username.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.userPassword.info.UpswdInfo;

final class UsernameCopyUpswd extends InfoCopierTemplate<UsernameInfo, UpswdInfo>{
	
	public UsernameCopyUpswd() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(UpswdInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
