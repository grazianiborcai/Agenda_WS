package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StordagrSetterLChanged extends InfoSetterTemplate<StordagrInfo> {
	
	@Override protected StordagrInfo setAttrHook(StordagrInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
