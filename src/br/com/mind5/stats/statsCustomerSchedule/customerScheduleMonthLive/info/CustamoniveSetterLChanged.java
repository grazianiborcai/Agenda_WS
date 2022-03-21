package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CustamoniveSetterLChanged extends InfoSetterTemplate<CustamoniveInfo> {
	
	@Override protected CustamoniveInfo setAttrHook(CustamoniveInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
