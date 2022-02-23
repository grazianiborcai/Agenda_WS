package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StordiveSetterLChanged extends InfoSetterTemplate<StordiveInfo> {
	
	@Override protected StordiveInfo setAttrHook(StordiveInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
