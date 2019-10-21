package br.com.mind5.business.address.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class AddressCopyStolis extends InfoCopierTemplate<AddressInfo, StolisInfo>{
	
	public AddressCopyStolis() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(StolisInfo source) {
		AddressInfo result = new AddressInfo();
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		return result;
	}
}
