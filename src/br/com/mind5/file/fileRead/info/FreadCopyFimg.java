package br.com.mind5.file.fileRead.info;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FreadCopyFimg extends InfoCopierTemplate<FreadInfo, FimgInfo> {
	
	public FreadCopyFimg() {
		super();
	}
	
	
	
	@Override protected FreadInfo makeCopyHook(FimgInfo source) {
		FreadInfo result = new FreadInfo();
		
		result.fileUri = source.fileImgUri;		
		return result;
	}
}
