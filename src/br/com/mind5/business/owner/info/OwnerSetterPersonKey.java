package br.com.mind5.business.owner.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OwnerSetterPersonKey extends InfoSetterTemplate<OwnerInfo> {
	
	@Override protected OwnerInfo setAttrHook(OwnerInfo recordInfo) {
		recordInfo.personData.codOwner = recordInfo.codOwner;
		recordInfo.personData.codPerson = recordInfo.codPerson;
		recordInfo.companyData.username = recordInfo.username;
		recordInfo.personData.codLanguage = recordInfo.codLanguage;
		
		return recordInfo;
	}
}
