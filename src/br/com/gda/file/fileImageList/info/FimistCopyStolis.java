package br.com.gda.file.fileImageList.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoCopierTemplate;

final class FimistCopyStolis extends InfoCopierTemplate<FimistInfo, StolisInfo>{
	
	public FimistCopyStolis() {
		super();
	}
	
	
	
	@Override protected FimistInfo makeCopyHook(StolisInfo source) {
		FimistInfo result = new FimistInfo();
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
