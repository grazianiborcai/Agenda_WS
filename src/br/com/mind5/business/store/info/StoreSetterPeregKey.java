package br.com.mind5.business.store.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StoreSetterPeregKey extends InfoSetterTemplate<StoreInfo> {
	
	@Override protected StoreInfo setAttrHook(StoreInfo recordInfo) {
		recordInfo.peregData.codOwner = recordInfo.codOwner;
		recordInfo.peregData.codStore = recordInfo.codStore;
		recordInfo.peregData.username = recordInfo.username;
		recordInfo.peregData.codLanguage = recordInfo.codLanguage;
		
		return recordInfo;
	}
}
