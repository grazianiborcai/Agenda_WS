package br.com.mind5.payment.storePartnerSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StoparchSetterStoreKey extends InfoSetterTemplate<StoparchInfo> {
	
	@Override protected StoparchInfo setAttrHook(StoparchInfo recordInfo) {
		StoparchInfo result = new StoparchInfo();
		
		result.codOwner      = recordInfo.codOwner;
		result.codStore      = recordInfo.codStore;
		result.username      = recordInfo.username;
		result.codLanguage   = recordInfo.codLanguage;
		result.codPayPartner = recordInfo.codPayPartner;
		
		return result;
	}
}
