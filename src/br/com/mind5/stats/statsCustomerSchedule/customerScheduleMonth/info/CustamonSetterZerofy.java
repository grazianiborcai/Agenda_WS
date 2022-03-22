package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CustamonSetterZerofy extends InfoSetterTemplate<CustamonInfo> {
	
	@Override protected CustamonInfo setAttrHook(CustamonInfo recordInfo) {
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
