package br.com.mind5.business.storeText.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatextCopyMatKey extends InfoCopierTemplate<StorextInfo, MatInfo> {
	
	public MatextCopyMatKey() {
		super();
	}
	
	
	
	@Override protected StorextInfo makeCopyHook(MatInfo source) {
		StorextInfo result = new StorextInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codMat;
		result.codLanguage = null;
		result.username = source.username;
		
		return result;
	}
}
