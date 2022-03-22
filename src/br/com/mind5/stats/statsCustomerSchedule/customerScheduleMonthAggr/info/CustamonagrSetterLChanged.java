package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CustamonagrSetterLChanged extends InfoSetterTemplate<CustamonagrInfo> {
	
	@Override protected CustamonagrInfo setAttrHook(CustamonagrInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
