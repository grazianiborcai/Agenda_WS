package br.com.mind5.security.username.info;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyCusarch extends InfoCopierTemplate<UsernameInfo, CusarchInfo> {
	
	public UsernameCopyCusarch() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(CusarchInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
