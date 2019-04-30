package br.com.gda.business.phone.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoCopierTemplate;

final class PhoneCopyStore extends InfoCopierTemplate<PhoneInfo, StoreInfo>{
	
	public PhoneCopyStore() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(StoreInfo source) {
		PhoneInfo result = new PhoneInfo();
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
