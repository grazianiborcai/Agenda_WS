package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CutefilonSetterZerofy extends InfoSetterTemplate<CutefilonInfo> {
	
	@Override protected CutefilonInfo setAttrHook(CutefilonInfo recordInfo) {
		recordInfo.countScheduleCancelled = 0;
		recordInfo.countScheduleWaiting = 0;
		recordInfo.countScheduleConfirmed = 0;
		recordInfo.countScheduleTotal = 0;

		return recordInfo;
	}
}
