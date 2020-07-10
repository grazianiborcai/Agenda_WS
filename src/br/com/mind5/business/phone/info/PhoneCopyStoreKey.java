package br.com.mind5.business.phone.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PhoneCopyStoreKey extends InfoCopierTemplate<PhoneInfo, StoreInfo> {
	
	public PhoneCopyStoreKey() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(StoreInfo source) {
		PhoneInfo result = new PhoneInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
