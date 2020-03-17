package br.com.mind5.file.fileImageList.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FimistCopyMatlis extends InfoCopierTemplate<FimistInfo, MatlisInfo>{
	
	public FimistCopyMatlis() {
		super();
	}
	
	
	
	@Override protected FimistInfo makeCopyHook(MatlisInfo source) {
		FimistInfo result = new FimistInfo();
		
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
