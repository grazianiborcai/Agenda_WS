package br.com.gda.business.store.info;

import br.com.gda.business.ownerStore_.info.OwntoreInfo;
import br.com.gda.info.InfoCopierTemplate;

final class StoreCopyOwntore extends InfoCopierTemplate<StoreInfo, OwntoreInfo>{
	
	public StoreCopyOwntore() {
		super();
	}
	
	
	
	@Override protected StoreInfo makeCopyHook(OwntoreInfo source) {
		StoreInfo result = new StoreInfo();
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
