package br.com.mind5.security.userSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class UserarchCopyPayord extends InfoCopierTemplate<UserarchInfo, PayordInfo> {
	
	public UserarchCopyPayord() {
		super();
	}
	
	
	
	@Override protected UserarchInfo makeCopyHook(PayordInfo source) {
		UserarchInfo result = new UserarchInfo();
		
		result.codOwner = source.codOwner;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
