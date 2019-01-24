package br.com.gda.business.address.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoCopierTemplate;

final class AddressCopyStore extends InfoCopierTemplate<AddressInfo, StoreInfo>{
	
	public AddressCopyStore() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(StoreInfo source) {
		AddressInfo result = new AddressInfo();
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		return result;
	}
}
