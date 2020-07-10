package br.com.mind5.business.storeLeaveDateSearch.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StolarchCopyStore extends InfoCopierTemplate<StolarchInfo, StoreInfo> {
	
	public StolarchCopyStore() {
		super();
	}
	
	
	
	@Override protected StolarchInfo makeCopyHook(StoreInfo source) {
		StolarchInfo result = new StolarchInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
