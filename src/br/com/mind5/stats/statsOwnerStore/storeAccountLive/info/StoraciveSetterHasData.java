package br.com.mind5.stats.statsStoreAccount.storeAccountLive.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StoraciveSetterHasData extends InfoSetterTemplate<StoraciveInfo> {
	
	@Override protected StoraciveInfo setAttrHook(StoraciveInfo recordInfo) {
		recordInfo.hasData = true;
		return recordInfo;
	}
}
