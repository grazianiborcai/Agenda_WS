package br.com.mind5.security.username.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class UsernameCopyCuspar extends InfoCopierTemplate<UsernameInfo, CusparInfo> {
	
	public UsernameCopyCuspar() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(CusparInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
