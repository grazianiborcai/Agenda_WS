package br.com.gda.security.username.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.customerPartner.info.CusparInfo;

final class UsernameCopyCuspar extends InfoCopierTemplate<UsernameInfo, CusparInfo>{
	
	public UsernameCopyCuspar() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(CusparInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
