package br.com.gda.business.addressSnapshot.info;

import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class AddresnapCopyStorap extends InfoCopierTemplate<AddresnapInfo, StorapInfo>{
	
	public AddresnapCopyStorap() {
		super();
	}
	
	
	
	@Override protected AddresnapInfo makeCopyHook(StorapInfo source) {
		AddresnapInfo result = new AddresnapInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codStoreSnapshot = source.codSnapshot;
		result.codLanguage = source.codLanguage;		
		
		return result;
	}
}
