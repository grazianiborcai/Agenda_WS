package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StowotmSetterStoreKey extends InfoSetterTemplate<StowotmInfo> {
	
	@Override protected StowotmInfo setAttrHook(StowotmInfo recordInfo) {
		StowotmInfo result = new StowotmInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
