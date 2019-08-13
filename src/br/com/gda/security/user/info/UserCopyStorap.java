package br.com.gda.security.user.info;

import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UserCopyStorap extends InfoCopierTemplate<UserInfo, StorapInfo>{
	
	public UserCopyStorap() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(StorapInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
