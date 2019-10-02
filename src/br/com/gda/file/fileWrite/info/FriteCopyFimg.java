package br.com.gda.file.fileWrite.info;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.info.InfoCopierTemplate;

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
