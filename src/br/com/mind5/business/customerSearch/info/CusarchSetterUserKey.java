package br.com.mind5.business.customerSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CusarchSetterUserKey extends InfoSetterTemplate<CusarchInfo> {
	
	@Override protected CusarchInfo setAttrHook(CusarchInfo recordInfo) {	
		CusarchInfo result = new CusarchInfo();
		
		result.codOwner = recordInfo.codOwner;	
		result.codUser = recordInfo.codUser;
		result.codStore = recordInfo.codStore;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}	
}
