package br.com.mind5.file.fileImageList.info;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FimistCopyStorby extends InfoCopierTemplate<FimistInfo, StorbyInfo> {
	
	public FimistCopyStorby() {
		super();
	}
	
	
	
	@Override protected FimistInfo makeCopyHook(StorbyInfo source) {
		FimistInfo result = new FimistInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
