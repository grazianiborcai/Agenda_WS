package br.com.gda.security.user.info;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UserCopyCusKey extends InfoCopierTemplate<UserInfo, CusInfo>{
	
	public UserCopyCusKey() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(CusInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
