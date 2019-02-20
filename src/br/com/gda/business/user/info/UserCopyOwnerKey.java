package br.com.gda.business.user.info;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UserCopyOwnerKey extends InfoCopierTemplate<UserInfo, OwnerInfo>{
	
	public UserCopyOwnerKey() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(OwnerInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
