package br.com.mind5.business.materialText.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatextCopyMatKey extends InfoCopierTemplate<MatextInfo, MatInfo> {
	
	public MatextCopyMatKey() {
		super();
	}
	
	
	
	@Override protected MatextInfo makeCopyHook(MatInfo source) {
		MatextInfo result = new MatextInfo();
		
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = null;
		result.username = source.username;
		
		return result;
	}
}
