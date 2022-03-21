package br.com.mind5.business.store.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StoreSetterLockedOn extends InfoSetterTemplate<StoreInfo> {
	
	@Override protected StoreInfo setAttrHook(StoreInfo recordInfo) {
		recordInfo.isLocked = true;
		
		return recordInfo;
	}
}
