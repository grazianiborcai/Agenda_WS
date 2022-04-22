package br.com.mind5.business.storeWorkTimeSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StowotarchSetterStoreKey extends InfoSetterTemplate<StowotarchInfo> {
	
	@Override protected StowotarchInfo setAttrHook(StowotarchInfo recordInfo) {
		StowotarchInfo result = new StowotarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;

		return result;
	}
}
