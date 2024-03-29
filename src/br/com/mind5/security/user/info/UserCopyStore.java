package br.com.mind5.security.user.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UserCopyStore extends InfoCopierTemplate<UserInfo, StoreInfo> {
	
	public UserCopyStore() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(StoreInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;		
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		result.personData = source.userPersonData;
		
		return result;
	}
}
