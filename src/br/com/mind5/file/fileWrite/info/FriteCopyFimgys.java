package br.com.mind5.file.fileWrite.info;

import br.com.mind5.file.fileImageSys.info.FimgysInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FriteCopyFimgys extends InfoCopierTemplate<FriteInfo, FimgysInfo> {
	
	public FriteCopyFimgys() {
		super();
	}
	
	
	
	@Override protected FriteInfo makeCopyHook(FimgysInfo source) {
		FriteInfo result = new FriteInfo();
		
		result.fileUri = source.fileImgUri;
		result.fileData = source.fileImgData;
		
		return result;
	}
}
