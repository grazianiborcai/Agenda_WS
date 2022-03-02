package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SowusagrSetterLChanged extends InfoSetterTemplate<SowusagrInfo> {
	
	@Override protected SowusagrInfo setAttrHook(SowusagrInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
