package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StedmonSetterZerofy extends InfoSetterTemplate<StedmonInfo> {
	
	@Override protected StedmonInfo setAttrHook(StedmonInfo recordInfo) {
		recordInfo.countScheduleCancelledMonth = 0;
		recordInfo.countScheduleWaitingMonth = 0;
		recordInfo.countScheduleConfirmedMonth = 0;
		recordInfo.countScheduleTotalMonth = 0;		
		recordInfo.countScheduleCancelledLastYear = 0;
		recordInfo.countScheduleWaitingLastYear = 0;
		recordInfo.countScheduleConfirmedLastYear = 0;
		recordInfo.countScheduleTotalLastYear = 0;

		return recordInfo;
	}
}
