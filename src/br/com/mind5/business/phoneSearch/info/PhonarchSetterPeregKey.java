package br.com.mind5.business.phoneSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PhonarchSetterPeregKey extends InfoSetterTemplate<PhonarchInfo> {
	
	@Override protected PhonarchInfo setAttrHook(PhonarchInfo recordInfo) {
		PhonarchInfo result = new PhonarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codLegalPerson = recordInfo.codLegalPerson;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
