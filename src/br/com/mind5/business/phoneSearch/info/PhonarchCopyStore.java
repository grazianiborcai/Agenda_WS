package br.com.mind5.business.phoneSearch.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PhonarchCopyStore extends InfoCopierTemplate<PhonarchInfo, StoreInfo> {
	
	public PhonarchCopyStore() {
		super();
	}
	
	
	
	@Override protected PhonarchInfo makeCopyHook(StoreInfo source) {
		PhonarchInfo result = new PhonarchInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
