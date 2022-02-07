package br.com.mind5.stats.statsStoreAccount.storeAccountLive.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StoraciveSetterLChanged extends InfoSetterTemplate<StoraciveInfo> {
	
	@Override protected StoraciveInfo setAttrHook(StoraciveInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
