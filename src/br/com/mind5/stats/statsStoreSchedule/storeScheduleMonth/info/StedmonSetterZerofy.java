package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StedmonSetterZerofy extends InfoSetterTemplate<StedmonInfo> {
	
	@Override protected StedmonInfo setAttrHook(StedmonInfo recordInfo) {
		recordInfo.countScheduleCancelledDay = 0;
		recordInfo.countScheduleWaitingDay = 0;
		recordInfo.countScheduleConfirmedDay = 0;
		recordInfo.countScheduleTotalDay = 0;

		return recordInfo;
	}
}
