package br.com.mind5.business.phoneSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PhonarchSetterCusPhoneKey extends InfoSetterTemplate<PhonarchInfo> {
	
	@Override protected PhonarchInfo setAttrHook(PhonarchInfo recordInfo) {
		PhonarchInfo result = new PhonarchInfo();		
		
		result.codOwner    = recordInfo.codOwner;		
		result.codPhone    = recordInfo.codPhone;		
		result.username    = recordInfo.username;
		result.codCustomer = recordInfo.codCustomer;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
