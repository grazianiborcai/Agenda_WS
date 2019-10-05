package br.com.gda.business.phone.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoCopierTemplate;

final class PhoneCopyStoreKey extends InfoCopierTemplate<PhoneInfo, StoreInfo>{
	
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
