package br.com.gda.file.fileImageList.info;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopierTemplate;

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
