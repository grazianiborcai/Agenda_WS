package br.com.mind5.security.username.info;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopySotarch extends InfoCopierTemplate<UsernameInfo, SotarchInfo> {
	
	public UsernameCopySotarch() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(SotarchInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
