package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StedmoniveSetterLChanged extends InfoSetterTemplate<StedmoniveInfo> {
	
	@Override protected StedmoniveInfo setAttrHook(StedmoniveInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
