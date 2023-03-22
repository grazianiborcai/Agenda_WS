package br.com.mind5.business.phoneSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PhonarchSetterUserPhoneKey extends InfoSetterTemplate<PhonarchInfo> {
	
	@Override protected PhonarchInfo setAttrHook(PhonarchInfo recordInfo) {
		PhonarchInfo result = new PhonarchInfo();
		
		result.codUser     = recordInfo.codUser;
		result.codOwner    = recordInfo.codOwner;		
		result.codPhone    = recordInfo.codPhone;		
		result.username    = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
