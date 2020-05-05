package br.com.mind5.payment.creditCard.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CrecardSetterUserKey extends InfoSetterTemplate<CrecardInfo> {
	
	@Override protected CrecardInfo setAttrHook(CrecardInfo recordInfo) {
		CrecardInfo result = new CrecardInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codUser = recordInfo.codUser;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;

		return result;
	}
}
