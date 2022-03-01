package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SowotagrSetterLChanged extends InfoSetterTemplate<SowotagrInfo> {
	
	@Override protected SowotagrInfo setAttrHook(SowotagrInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
