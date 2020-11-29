package br.com.mind5.payment.customerPartnerSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CusparchSetterUserCustomerKey extends InfoSetterTemplate<CusparchInfo> {
	
	@Override protected CusparchInfo setAttrHook(CusparchInfo recordInfo) {
		CusparchInfo result = new CusparchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codUser = recordInfo.codUser;
		result.codPayCustomer = recordInfo.codPayCustomer;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;

		return result;
	}
}
