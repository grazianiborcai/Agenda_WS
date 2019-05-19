package br.com.gda.business.materialText.info;

import br.com.gda.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class MatextCopyMatextsnap extends InfoCopierTemplate<MatextInfo, MatextsnapInfo>{
	
	public MatextCopyMatextsnap() {
		super();
	}
	
	
	
	@Override protected MatextInfo makeCopyHook(MatextsnapInfo source) {
		MatextInfo result = new MatextInfo();
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		return result;
	}
}
