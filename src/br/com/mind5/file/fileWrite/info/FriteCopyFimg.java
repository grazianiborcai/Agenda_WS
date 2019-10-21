package br.com.mind5.file.fileWrite.info;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FriteCopyFimg extends InfoCopierTemplate<FriteInfo, FimgInfo>{
	
	public FriteCopyFimg() {
		super();
	}
	
	
	
	@Override protected FriteInfo makeCopyHook(FimgInfo source) {
		FriteInfo result = new FriteInfo();
		result.fileUri = source.fileImgUri;
		result.fileData = source.fileImgData;
		
		return result;
	}
}
