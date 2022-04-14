package br.com.mind5.business.storeLunchTimeSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StuntmarchSetterStoreKey extends InfoSetterTemplate<StuntmarchInfo> {
	
	@Override protected StuntmarchInfo setAttrHook(StuntmarchInfo recordInfo) {
		StuntmarchInfo result = new StuntmarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;

		return result;
	}
}
