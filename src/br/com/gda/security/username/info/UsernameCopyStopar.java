package br.com.gda.security.username.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.storePartner.info.StoparInfo;

final class UsernameCopyStopar extends InfoCopierTemplate<UsernameInfo, StoparInfo>{
	
	public UsernameCopyStopar() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(StoparInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
