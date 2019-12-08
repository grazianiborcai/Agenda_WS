package br.com.mind5.file.fileImageList.info;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FimistCopyOwner extends InfoCopierTemplate<FimistInfo, OwnerInfo>{
	
	public FimistCopyOwner() {
		super();
	}
	
	
	
	@Override protected FimistInfo makeCopyHook(OwnerInfo source) {
		FimistInfo result = new FimistInfo();
		
		result.codOwner = source.codOwner;
		result.codOwnerRef = source.codOwner;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
