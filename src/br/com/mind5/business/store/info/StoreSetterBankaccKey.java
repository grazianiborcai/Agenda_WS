package br.com.mind5.business.store.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StoreSetterBankaccKey extends InfoSetterTemplate<StoreInfo> {
	
	@Override protected StoreInfo setAttrHook(StoreInfo recordInfo) {
		recordInfo.bankaccData.codOwner = recordInfo.codOwner;
		recordInfo.bankaccData.codStore = recordInfo.codStore;
		recordInfo.bankaccData.username = recordInfo.username;
		
		
		return recordInfo;
	}
}
