package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SteddiveSetterLChanged extends InfoSetterTemplate<SteddiveInfo> {
	
	@Override protected SteddiveInfo setAttrHook(SteddiveInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
