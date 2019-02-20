package br.com.gda.business.user.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UserCopyStoreKey extends InfoCopierTemplate<UserInfo, StoreInfo>{
	
	public UserCopyStoreKey() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(StoreInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
