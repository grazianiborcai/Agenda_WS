package br.com.mind5.business.storeAccount.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StoracSetterAccountCompleted extends InfoSetterTemplate<StoracInfo> {
	
	@Override protected StoracInfo setAttrHook(StoracInfo recordInfo) {
		recordInfo.isAccountCompleted = true;
		
		return recordInfo;
	}
}
