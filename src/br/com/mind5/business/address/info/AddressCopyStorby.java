package br.com.mind5.business.address.info;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class AddressCopyStorby extends InfoCopierTemplate<AddressInfo, StorbyInfo> {
	
	public AddressCopyStorby() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(StorbyInfo source) {
		AddressInfo result = new AddressInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
