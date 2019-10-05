package br.com.gda.business.address.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoCopierTemplate;

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
