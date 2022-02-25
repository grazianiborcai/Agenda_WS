package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SowedulagrSetterLChanged extends InfoSetterTemplate<SowedulagrInfo> {
	
	@Override protected SowedulagrInfo setAttrHook(SowedulagrInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
