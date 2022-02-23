package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StoronagrSetterLChanged extends InfoSetterTemplate<StoronagrInfo> {
	
	@Override protected StoronagrInfo setAttrHook(StoronagrInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
