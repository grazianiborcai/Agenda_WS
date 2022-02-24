package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SowordagrSetterLChanged extends InfoSetterTemplate<SowordagrInfo> {
	
	@Override protected SowordagrInfo setAttrHook(SowordagrInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
