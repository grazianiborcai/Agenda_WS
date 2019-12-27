package br.com.mind5.security.user.info;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UserCopyCusDaemon extends InfoCopierTemplate<UserInfo, CusInfo>{
	
	public UserCopyCusDaemon() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(CusInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
