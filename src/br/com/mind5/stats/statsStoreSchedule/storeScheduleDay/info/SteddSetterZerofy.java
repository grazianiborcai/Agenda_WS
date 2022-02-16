package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SteddSetterZerofy extends InfoSetterTemplate<SteddInfo> {
	
	@Override protected SteddInfo setAttrHook(SteddInfo recordInfo) {
		recordInfo.countScheduleCancelledDay = 0;
		recordInfo.countScheduleWaitingDay = 0;
		recordInfo.countScheduleConfirmedDay = 0;
		recordInfo.countScheduleTotalDay = 0;

		return recordInfo;
	}
}
