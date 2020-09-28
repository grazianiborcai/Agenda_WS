package br.com.mind5.business.store.info;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class StoreSetterStorextKey extends InfoSetterTemplate<StoreInfo> {
	
	@Override protected StoreInfo setAttrHook(StoreInfo recordInfo) {
		for (StorextInfo eachStorext : recordInfo.storextes) {
			eachStorext.codOwner = recordInfo.codOwner;
			eachStorext.codStore = recordInfo.codStore;
			eachStorext.username = recordInfo.username;
			eachStorext.codLanguage = recordInfo.codLanguage;
		}
		
		return recordInfo;
	}
}
