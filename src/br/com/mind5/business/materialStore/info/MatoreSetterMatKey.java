package br.com.mind5.business.materialStore.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatoreSetterMatKey extends InfoSetterTemplate<MatoreInfo> {
	
	@Override protected MatoreInfo setAttrHook(MatoreInfo recordInfo) {	
		MatoreInfo result = new MatoreInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codMat = recordInfo.codMat;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
