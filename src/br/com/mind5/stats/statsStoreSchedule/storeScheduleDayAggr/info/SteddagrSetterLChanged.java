package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SteddagrSetterLChanged extends InfoSetterTemplate<SteddagrInfo> {
	
	@Override protected SteddagrInfo setAttrHook(SteddagrInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
