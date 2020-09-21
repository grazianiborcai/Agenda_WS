package br.com.mind5.business.storeText.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StorextCopyStoreKey extends InfoCopierTemplate<StorextInfo, StoreInfo> {
	
	public StorextCopyStoreKey() {
		super();
	}
	
	
	
	@Override protected StorextInfo makeCopyHook(StoreInfo source) {
		StorextInfo result = new StorextInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = null;
		result.username = source.username;
		
		return result;
	}
}
