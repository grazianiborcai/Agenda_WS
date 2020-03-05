package br.com.mind5.security.user.info;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UserCopyStorap extends InfoCopierTemplate<UserInfo, StorapInfo>{
	
	public UserCopyStorap() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(StorapInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
