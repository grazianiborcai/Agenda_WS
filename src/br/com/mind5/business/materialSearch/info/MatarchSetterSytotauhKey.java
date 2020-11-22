package br.com.mind5.business.materialSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatarchSetterSytotauhKey extends InfoSetterTemplate<MatarchInfo> {
	
	@Override protected MatarchInfo setAttrHook(MatarchInfo recordInfo) {
		MatarchInfo result = new MatarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codMat = recordInfo.codMat;
		result.codStore = recordInfo.codStore;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
