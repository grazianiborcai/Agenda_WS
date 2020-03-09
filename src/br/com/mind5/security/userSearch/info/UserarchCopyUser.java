package br.com.mind5.security.userSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class UserarchCopyUser extends InfoCopierTemplate<UserarchInfo, UserInfo>{
	
	public UserarchCopyUser() {
		super();
	}
	
	
	
	@Override protected UserarchInfo makeCopyHook(UserInfo source) {
		UserarchInfo result = new UserarchInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
