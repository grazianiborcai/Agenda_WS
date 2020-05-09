package br.com.mind5.security.userSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

final class UserarchCopyRefem extends InfoCopierTemplate<UserarchInfo, RefemInfo>{
	
	public UserarchCopyRefem() {
		super();
	}
	
	
	
	@Override protected UserarchInfo makeCopyHook(RefemInfo source) {
		UserarchInfo result = new UserarchInfo();
		
		result.codOwner = source.codOwner;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
