package br.com.mind5.security.username.info;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyCus extends InfoCopierTemplate<UsernameInfo, CusInfo> {
	
	public UsernameCopyCus() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(CusInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
