package br.com.mind5.business.store.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StoreSetterCompKey extends InfoSetterTemplate<StoreInfo> {
	
	@Override protected StoreInfo setAttrHook(StoreInfo recordInfo) {
		recordInfo.companyData.codOwner = recordInfo.codOwner;
		recordInfo.companyData.codCompany = recordInfo.codCompany;
		recordInfo.companyData.username = recordInfo.username;
		recordInfo.companyData.codLanguage = recordInfo.codLanguage;
		
		return recordInfo;
	}
}
