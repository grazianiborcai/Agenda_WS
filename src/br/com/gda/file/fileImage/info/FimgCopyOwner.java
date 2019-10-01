package br.com.gda.file.fileImage.info;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopierTemplate;

final class FimgCopyOwner extends InfoCopierTemplate<FimgInfo, OwnerInfo>{
	
	public FimgCopyOwner() {
		super();
	}
	
	
	
	@Override protected FimgInfo makeCopyHook(OwnerInfo source) {		
		FimgInfo result = new FimgInfo();
		
		result.codOwner = source.codOwner;
		result.codOwnerRef = source.codOwner;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
