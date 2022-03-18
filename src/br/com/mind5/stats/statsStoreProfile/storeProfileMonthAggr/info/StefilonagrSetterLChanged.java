package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StefilonagrSetterLChanged extends InfoSetterTemplate<StefilonagrInfo> {
	
	@Override protected StefilonagrInfo setAttrHook(StefilonagrInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
