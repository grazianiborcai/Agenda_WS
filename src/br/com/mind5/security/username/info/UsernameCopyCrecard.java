package br.com.mind5.security.username.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class UsernameCopyCrecard extends InfoCopierTemplate<UsernameInfo, CrecardInfo>{
	
	public UsernameCopyCrecard() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(CrecardInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
