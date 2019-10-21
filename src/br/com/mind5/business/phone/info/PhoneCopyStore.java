package br.com.mind5.business.phone.info;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class PhoneCopyStore extends InfoCopierOneToManyTemplate<PhoneInfo, StoreInfo>{
	
	public PhoneCopyStore() {
		super();
	}
	
	
	
	@Override protected List<PhoneInfo> makeCopyHook(StoreInfo source) {
		return source.phones;
	}
}
