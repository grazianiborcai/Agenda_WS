package br.com.mind5.business.personLegal.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PeregSetterPhoneKey extends InfoSetterTemplate<PeregInfo> {
	
	@Override protected PeregInfo setAttrHook(PeregInfo recordInfo) {
		recordInfo.phoneData.codOwner = recordInfo.codOwner;
		recordInfo.phoneData.codLegalPerson = recordInfo.codLegalPerson;
		recordInfo.phoneData.username = recordInfo.username;
		recordInfo.phoneData.codLanguage = recordInfo.codLanguage;
		
		return recordInfo;
	}
}
