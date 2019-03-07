package br.com.gda.security.username.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UsernameCopyStore extends InfoCopierTemplate<UsernameInfo, StoreInfo>{
	
	public UsernameCopyStore() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(StoreInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
