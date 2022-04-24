package br.com.mind5.business.store.info;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class StoreSetterStuntmKey extends InfoSetterTemplate<StoreInfo> {
	
	@Override protected StoreInfo setAttrHook(StoreInfo recordInfo) {
		for (StuntmInfo eachStuntm : recordInfo.stuntmes) {
			eachStuntm.codOwner = recordInfo.codOwner;
			eachStuntm.codStore = recordInfo.codStore;
			eachStuntm.username = recordInfo.username;
			eachStuntm.codLanguage = recordInfo.codLanguage;
		}
		
		return recordInfo;
	}
}
