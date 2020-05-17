package br.com.mind5.security.username.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.storePartner.info.StoparInfo;

final class UsernameCopyStopar extends InfoCopierTemplate<UsernameInfo, StoparInfo> {
	
	public UsernameCopyStopar() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(StoparInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
