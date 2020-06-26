package br.com.mind5.security.user.info;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UserCopyOwnerKey extends InfoCopierTemplate<UserInfo, OwnerInfo> {
	
	public UserCopyOwnerKey() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(OwnerInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
