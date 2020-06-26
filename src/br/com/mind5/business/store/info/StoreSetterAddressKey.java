package br.com.mind5.business.store.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StoreSetterAddressKey extends InfoSetterTemplate<StoreInfo> {
	
	@Override protected StoreInfo setAttrHook(StoreInfo recordInfo) {
		recordInfo.addressData.codOwner = recordInfo.codOwner;
		recordInfo.addressData.codStore = recordInfo.codStore;
		recordInfo.addressData.username = recordInfo.username;
		recordInfo.addressData.codLanguage = recordInfo.codLanguage;
		
		return recordInfo;
	}
}
