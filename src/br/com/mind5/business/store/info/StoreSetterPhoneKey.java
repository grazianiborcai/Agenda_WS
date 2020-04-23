package br.com.mind5.business.store.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class StoreSetterPhoneKey extends InfoSetterTemplate<StoreInfo> {
	
	@Override protected StoreInfo setAttrHook(StoreInfo recordInfo) {
		for (PhoneInfo eachPhone : recordInfo.phones) {
			eachPhone.codOwner = recordInfo.codOwner;
			eachPhone.codStore = recordInfo.codStore;
			eachPhone.username = recordInfo.username;
			eachPhone.codLanguage = recordInfo.codLanguage;
		}
		
		return recordInfo;
	}
}
