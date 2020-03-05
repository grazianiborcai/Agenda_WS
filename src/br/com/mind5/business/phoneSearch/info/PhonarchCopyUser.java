package br.com.mind5.business.phoneSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class PhonarchCopyUser extends InfoCopierTemplate<PhonarchInfo, UserInfo>{
	
	public PhonarchCopyUser() {
		super();
	}
	
	
	
	@Override protected PhonarchInfo makeCopyHook(UserInfo source) {
		PhonarchInfo result = new PhonarchInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
