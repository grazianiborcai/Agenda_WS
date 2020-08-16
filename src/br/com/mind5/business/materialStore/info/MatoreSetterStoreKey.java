package br.com.mind5.business.materialStore.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatoreSetterStoreKey extends InfoSetterTemplate<MatoreInfo> {
	
	@Override protected MatoreInfo setAttrHook(MatoreInfo recordInfo) {	
		MatoreInfo result = new MatoreInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
