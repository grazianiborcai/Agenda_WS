package br.com.mind5.business.storeSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SotarchSetterUserKey extends InfoSetterTemplate<SotarchInfo> {
	
	@Override protected SotarchInfo setAttrHook(SotarchInfo recordInfo) {
		SotarchInfo result = new SotarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codUser = recordInfo.codUser;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
