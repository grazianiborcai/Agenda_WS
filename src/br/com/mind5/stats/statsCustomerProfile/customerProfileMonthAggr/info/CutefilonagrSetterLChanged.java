package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CutefilonagrSetterLChanged extends InfoSetterTemplate<CutefilonagrInfo> {
	
	@Override protected CutefilonagrInfo setAttrHook(CutefilonagrInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
