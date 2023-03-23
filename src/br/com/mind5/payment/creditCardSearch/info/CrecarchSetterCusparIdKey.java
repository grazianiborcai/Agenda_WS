package br.com.mind5.payment.creditCardSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CrecarchSetterCusparIdKey extends InfoSetterTemplate<CrecarchInfo> {
	
	@Override protected CrecarchInfo setAttrHook(CrecarchInfo recordInfo) {
		CrecarchInfo result = new CrecarchInfo();		
		
		result.codOwner       = recordInfo.codOwner;
		result.username       = recordInfo.username;		
		result.codLanguage    = recordInfo.codLanguage;
		result.creditCardId   = recordInfo.creditCardId;
		result.codPayCustomer = recordInfo.codPayCustomer;
		
		return result;
	}
}
