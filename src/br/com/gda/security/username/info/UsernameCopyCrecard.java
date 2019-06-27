package br.com.gda.security.username.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.creditCard.info.CrecardInfo;

final class UsernameCopyCrecard extends InfoCopierTemplate<UsernameInfo, CrecardInfo>{
	
	public UsernameCopyCrecard() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(CrecardInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
