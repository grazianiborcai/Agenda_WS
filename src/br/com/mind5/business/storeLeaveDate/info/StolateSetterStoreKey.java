package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StolateSetterStoreKey extends InfoSetterTemplate<StolateInfo> {
	
	@Override protected StolateInfo setAttrHook(StolateInfo recordInfo) {
		StolateInfo result = new StolateInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;

		return result;
	}
}
