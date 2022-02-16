package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SteddSetterYearMonth extends InfoSetterTemplate<SteddInfo> {
	
	@Override protected SteddInfo setAttrHook(SteddInfo recordInfo) {
		SteddInfo result = new SteddInfo();
		
		recordInfo.year = Integer.parseInt(recordInfo.calmonth.substring(0,4));
		recordInfo.month = Integer.parseInt(recordInfo.calmonth.substring(4,6));

		return result;
	}
}
