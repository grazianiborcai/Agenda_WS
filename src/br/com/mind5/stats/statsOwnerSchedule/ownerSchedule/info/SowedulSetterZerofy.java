package br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowedulSetterZerofy extends InfoSetterTemplate<SowedulInfo> {
	
	@Override protected SowedulInfo setAttrHook(SowedulInfo recordInfo) {
		recordInfo.countScheduleCancelledMonth = 0;
		recordInfo.countScheduleWaitingMonth = 0;
		recordInfo.countScheduleConfirmedMonth = 0;
		recordInfo.countScheduleTotalMonth = 0;
		recordInfo.countScheduleCancelledLastYear = 0;
		recordInfo.countScheduleWaitingLastYear = 0;
		recordInfo.countScheduleConfirmedLastYear = 0;	
		recordInfo.countScheduleTotalLastYear = 0;
		recordInfo.countScheduleCancelledVar = 0;
		recordInfo.countScheduleWaitingVar = 0;
		recordInfo.countScheduleConfirmedVar = 0;	
		recordInfo.countScheduleTotalVar = 0;

		return recordInfo;
	}
}
