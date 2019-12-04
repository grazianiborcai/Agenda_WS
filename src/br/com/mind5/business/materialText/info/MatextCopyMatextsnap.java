package br.com.mind5.business.materialText.info;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatextCopyMatextsnap extends InfoCopierTemplate<MatextInfo, MatextsnapInfo>{
	
	public MatextCopyMatextsnap() {
		super();
	}
	
	
	
	@Override protected MatextInfo makeCopyHook(MatextsnapInfo source) {
		MatextInfo result = new MatextInfo();
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = null;
		result.username = source.username;
		return result;
	}
}
