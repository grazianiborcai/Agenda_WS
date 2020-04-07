package br.com.mind5.business.owner.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OwnerSetterCompKey extends InfoSetterTemplate<OwnerInfo> {
	
	@Override protected OwnerInfo setAttrHook(OwnerInfo recordInfo) {
		recordInfo.companyData.codOwner = recordInfo.codOwner;
		recordInfo.companyData.codCompany = recordInfo.codCompany;
		recordInfo.companyData.username = recordInfo.username;
		recordInfo.companyData.codLanguage = recordInfo.codLanguage;
		
		return recordInfo;
	}
}
