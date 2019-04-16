package br.com.gda.business.user.info;

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
		result.username = source.username;
		
		return result;
	}
}
