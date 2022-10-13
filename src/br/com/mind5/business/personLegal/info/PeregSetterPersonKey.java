package br.com.mind5.business.personLegal.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PeregSetterPersonKey extends InfoSetterTemplate<PeregInfo> {
	
	@Override protected PeregInfo setAttrHook(PeregInfo recordInfo) {
		recordInfo.personData.codOwner = recordInfo.codOwner;
		recordInfo.personData.codStore = recordInfo.codStore;
		recordInfo.personData.username = recordInfo.username;
		recordInfo.personData.codLanguage = recordInfo.codLanguage;
		
		return recordInfo;
	}
}
