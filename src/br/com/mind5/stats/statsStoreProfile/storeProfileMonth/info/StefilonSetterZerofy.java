package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StefilonSetterZerofy extends InfoSetterTemplate<StefilonInfo> {
	
	@Override protected StefilonInfo setAttrHook(StefilonInfo recordInfo) {
		recordInfo.countScheduleCancelled = 0;
		recordInfo.countScheduleWaiting = 0;
		recordInfo.countScheduleConfirmed = 0;
		recordInfo.countScheduleTotal = 0;		
		recordInfo.countGoods = 0;
		recordInfo.countService = 0;
		recordInfo.countEmployee = 0;
		recordInfo.countCustomer = 0;

		return recordInfo;
	}
}
