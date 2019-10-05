package br.com.gda.business.address.info;

import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class AddressCopyStore extends InfoCopierOneToManyTemplate<AddressInfo, StoreInfo>{
	
	public AddressCopyStore() {
		super();
	}
	
	
	
	@Override protected List<AddressInfo> makeCopyHook(StoreInfo source) {
		return source.addresses;
	}
}
