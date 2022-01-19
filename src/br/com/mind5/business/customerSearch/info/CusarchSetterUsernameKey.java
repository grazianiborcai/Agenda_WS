package br.com.mind5.business.customerSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CusarchSetterUsernameKey extends InfoSetterTemplate<CusarchInfo> {
	
	@Override protected CusarchInfo setAttrHook(CusarchInfo recordInfo) {	
		CusarchInfo result = new CusarchInfo();
		
		result.codOwner = recordInfo.codOwner;	
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}	
}
