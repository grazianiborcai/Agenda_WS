package br.com.mind5.payment.storePartnerSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StoparchSetterStoreKey extends InfoSetterTemplate<StoparchInfo> {
	
	@Override protected StoparchInfo setAttrHook(StoparchInfo recordInfo) {
		StoparchInfo result = new StoparchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codPayPartner = recordInfo.codPayPartner;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
