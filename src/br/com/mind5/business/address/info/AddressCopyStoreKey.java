package br.com.mind5.business.address.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class AddressCopyStoreKey extends InfoCopierTemplate<AddressInfo, StoreInfo>{
	
	public AddressCopyStoreKey() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(StoreInfo source) {
		AddressInfo result = new AddressInfo();
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		return result;
	}
}
