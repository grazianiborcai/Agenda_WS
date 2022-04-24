package br.com.mind5.business.store.info;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class StoreSetterStowotmKey extends InfoSetterTemplate<StoreInfo> {
	
	@Override protected StoreInfo setAttrHook(StoreInfo recordInfo) {
		for (StowotmInfo eachStowotm : recordInfo.stowotmes) {
			eachStowotm.codOwner = recordInfo.codOwner;
			eachStowotm.codStore = recordInfo.codStore;
			eachStowotm.username = recordInfo.username;
			eachStowotm.codLanguage = recordInfo.codLanguage;
		}
		
		return recordInfo;
	}
}
