package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class AddresnapCopyStorap extends InfoCopierTemplate<AddresnapInfo, StorapInfo>{
	
	public AddresnapCopyStorap() {
		super();
	}
	
	
	
	@Override protected AddresnapInfo makeCopyHook(StorapInfo source) {
		AddresnapInfo result = new AddresnapInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;		
		result.username = source.username;
		
		return result;
	}
}
