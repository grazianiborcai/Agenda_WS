package br.com.gda.file.fileImageList.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoCopierTemplate;

final class FimistCopyStore extends InfoCopierTemplate<FimistInfo, StoreInfo>{
	
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
