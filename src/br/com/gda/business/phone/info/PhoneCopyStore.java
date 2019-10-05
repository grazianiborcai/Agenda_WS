package br.com.gda.business.phone.info;

import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class PhoneCopyStore extends InfoCopierOneToManyTemplate<PhoneInfo, StoreInfo>{
	
	public PhoneCopyStore() {
		super();
	}
	
	
	
	@Override protected List<PhoneInfo> makeCopyHook(StoreInfo source) {
		return source.phones;
	}
}
