package br.com.gda.business.user.info;

import br.com.gda.info.InfoCopierTemplate;

final class UserCopyToDelete extends InfoCopierTemplate<UserInfo, UserInfo>{
	
	public UserCopyToDelete() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(UserInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
