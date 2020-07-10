package br.com.mind5.file.fileImage.info;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FimgCopyOwner extends InfoCopierTemplate<FimgInfo, OwnerInfo> {
	
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
