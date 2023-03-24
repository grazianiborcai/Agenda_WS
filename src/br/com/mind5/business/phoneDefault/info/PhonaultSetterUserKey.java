package br.com.mind5.business.phoneDefault.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PhonaultSetterUserKey extends InfoSetterTemplate<PhonaultInfo> {
	
	@Override protected PhonaultInfo setAttrHook(PhonaultInfo recordInfo) {
		PhonaultInfo result = new PhonaultInfo();		
		
		result.codUser     = recordInfo.codUser;
		result.codOwner    = recordInfo.codOwner;
		result.username    = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
