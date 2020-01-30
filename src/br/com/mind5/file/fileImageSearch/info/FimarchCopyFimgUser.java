package br.com.mind5.file.fileImageSearch.info;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FimarchCopyFimgUser extends InfoCopierTemplate<FimarchInfo, FimgInfo>{
	
	public FimarchCopyFimgUser() {
		super();
	}
	
	
	
	@Override protected FimarchInfo makeCopyHook(FimgInfo source) {		
		FimarchInfo result = new FimarchInfo();
		
		result.codOwner = source.codOwner;
		result.codFileImg = source.codFileImg;
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
