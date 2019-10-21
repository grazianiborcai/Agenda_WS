package br.com.mind5.business.materialText.info;

import br.com.mind5.info.InfoCopierTemplate;

final class MatextCopyToDelete extends InfoCopierTemplate<MatextInfo, MatextInfo>{
	
	public MatextCopyToDelete() {
		super();
	}
	
	
	
	@Override protected MatextInfo makeCopyHook(MatextInfo source) {
		MatextInfo result = new MatextInfo();
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
