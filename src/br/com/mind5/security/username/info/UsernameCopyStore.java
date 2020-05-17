package br.com.mind5.security.username.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyStore extends InfoCopierTemplate<UsernameInfo, StoreInfo> {
	
	public UsernameCopyStore() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(StoreInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
