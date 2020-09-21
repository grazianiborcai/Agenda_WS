package br.com.mind5.business.storeText.info;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StorextCopyMatextsnap extends InfoCopierTemplate<StorextInfo, MatextsnapInfo> {
	
	public StorextCopyMatextsnap() {
		super();
	}
	
	
	
	@Override protected StorextInfo makeCopyHook(MatextsnapInfo source) {
		StorextInfo result = new StorextInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codMat;
		result.codLanguage = null;
		result.username = source.username;
		
		return result;
	}
}
