package br.com.mind5.business.storeAccount.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StoracSetterHasPartner extends InfoSetterTemplate<StoracInfo> {
	
	@Override protected StoracInfo setAttrHook(StoracInfo recordInfo) {
		recordInfo.hasPayPartner = true;
		
		return recordInfo;
	}
}
