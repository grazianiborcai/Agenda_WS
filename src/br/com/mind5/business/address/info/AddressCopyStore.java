package br.com.mind5.business.address.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class AddressCopyStore extends InfoCopierTemplate<AddressInfo, StoreInfo> {
	
	public AddressCopyStore() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(StoreInfo source) {
		return source.addressData;
	}
}
