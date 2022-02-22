package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StedmonagrSetterLChanged extends InfoSetterTemplate<StedmonagrInfo> {
	
	@Override protected StedmonagrInfo setAttrHook(StedmonagrInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
