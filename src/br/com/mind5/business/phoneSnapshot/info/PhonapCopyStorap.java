package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PhonapCopyStorap extends InfoCopierTemplate<PhonapInfo, StorapInfo> {
	
	public PhonapCopyStorap() {
		super();
	}
	
	
	
	@Override protected PhonapInfo makeCopyHook(StorapInfo source) {
		PhonapInfo result = new PhonapInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codStoreSnapshot = source.codSnapshot;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
