package br.com.mind5.file.fileImageList.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FimistCopyStore extends InfoCopierTemplate<FimistInfo, StoreInfo> {
	
	public FimistCopyStore() {
		super();
	}
	
	
	
	@Override protected FimistInfo makeCopyHook(StoreInfo source) {
		FimistInfo result = new FimistInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
