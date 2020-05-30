package br.com.mind5.business.address.info;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class AddressCopyStore extends InfoCopierOneToManyTemplate<AddressInfo, StoreInfo> {
	
	public AddressCopyStore() {
		super();
	}
	
	
	
	@Override protected List<AddressInfo> makeCopyHook(StoreInfo source) {
		return source.addresses;
	}
}
