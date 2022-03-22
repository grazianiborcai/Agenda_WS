package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CutefiloniveSetterLChanged extends InfoSetterTemplate<CutefiloniveInfo> {
	
	@Override protected CutefiloniveInfo setAttrHook(CutefiloniveInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
