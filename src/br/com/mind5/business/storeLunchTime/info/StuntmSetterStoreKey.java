package br.com.mind5.business.storeLunchTime.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StuntmSetterStoreKey extends InfoSetterTemplate<StuntmInfo> {
	
	@Override protected StuntmInfo setAttrHook(StuntmInfo recordInfo) {
		StuntmInfo result = new StuntmInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;

		return result;
	}
}
