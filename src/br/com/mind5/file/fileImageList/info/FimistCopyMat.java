package br.com.mind5.file.fileImageList.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FimistCopyMat extends InfoCopierTemplate<FimistInfo, MatInfo> {
	
	public FimistCopyMat() {
		super();
	}
	
	
	
	@Override protected FimistInfo makeCopyHook(MatInfo source) {
		FimistInfo result = new FimistInfo();
		
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
