package br.com.mind5.file.fileImageList.info;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FimistCopyOwnelis extends InfoCopierTemplate<FimistInfo, OwnelisInfo> {
	
	public FimistCopyOwnelis() {
		super();
	}
	
	
	
	@Override protected FimistInfo makeCopyHook(OwnelisInfo source) {
		FimistInfo result = new FimistInfo();
		
		result.codOwner = source.codOwner;
		result.codOwnerRef = source.codOwner;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
