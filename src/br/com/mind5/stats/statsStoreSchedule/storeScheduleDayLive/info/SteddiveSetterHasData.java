package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SteddiveSetterHasData extends InfoSetterTemplate<SteddiveInfo> {
	
	@Override protected SteddiveInfo setAttrHook(SteddiveInfo recordInfo) {
		recordInfo.hasData = true;
		return recordInfo;
	}
}
