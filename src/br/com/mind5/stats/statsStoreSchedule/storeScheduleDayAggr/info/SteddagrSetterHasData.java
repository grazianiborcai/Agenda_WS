package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SteddagrSetterHasData extends InfoSetterTemplate<SteddagrInfo> {
	
	@Override protected SteddagrInfo setAttrHook(SteddagrInfo recordInfo) {
		recordInfo.hasData = true;
		return recordInfo;
	}
}
