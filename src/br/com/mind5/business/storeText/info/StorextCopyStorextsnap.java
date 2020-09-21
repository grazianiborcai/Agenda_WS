package br.com.mind5.business.storeText.info;

import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StorextCopyStorextsnap extends InfoCopierTemplate<StorextInfo, StorextsnapInfo> {
	
	public StorextCopyStorextsnap() {
		super();
	}
	
	
	
	@Override protected StorextInfo makeCopyHook(StorextsnapInfo source) {
		StorextInfo result = new StorextInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = null;
		result.username = source.username;
		
		return result;
	}
}
