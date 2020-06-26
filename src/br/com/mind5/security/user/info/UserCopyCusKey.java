package br.com.mind5.security.user.info;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UserCopyCusKey extends InfoCopierTemplate<UserInfo, CusInfo> {
	
	public UserCopyCusKey() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(CusInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
