package br.com.mind5.payment.customerPartnerSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CusparchSetterUserKey extends InfoSetterTemplate<CusparchInfo> {
	
	@Override protected CusparchInfo setAttrHook(CusparchInfo recordInfo) {
		CusparchInfo result = new CusparchInfo();		
		
		result.codUser       = recordInfo.codUser;
		result.codOwner      = recordInfo.codOwner;
		result.username      = recordInfo.username;
		result.codLanguage   = recordInfo.codLanguage;
		result.codPayPartner = recordInfo.codPayPartner;

		return result;
	}
}
