package br.com.mind5.business.customer.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CusSetterPersonKey extends InfoSetterTemplate<CusInfo> {
	
	@Override protected CusInfo setAttrHook(CusInfo recordInfo) {
		recordInfo.personData.codOwner = recordInfo.codOwner;
		recordInfo.personData.codPerson = recordInfo.codPerson;
		recordInfo.personData.codStore = recordInfo.codStore;
		recordInfo.personData.username = recordInfo.username;
		recordInfo.personData.codLanguage = recordInfo.codLanguage;
		
		return recordInfo;
	}
}
