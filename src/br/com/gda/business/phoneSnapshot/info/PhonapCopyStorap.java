package br.com.gda.business.phoneSnapshot.info;

import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class PhonapCopyStorap extends InfoCopierTemplate<PhonapInfo, StorapInfo>{
	
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
