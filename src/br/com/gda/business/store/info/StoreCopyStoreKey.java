package br.com.gda.business.store.info;

import br.com.gda.info.InfoCopierTemplate;

final class StoreCopyStoreKey extends InfoCopierTemplate<StoreInfo, StoreInfo>{
	
	public StoreCopyStoreKey() {
		super();
	}
	
	
	
	@Override protected StoreInfo makeCopyHook(StoreInfo source) {
		StoreInfo result = new StoreInfo();
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
