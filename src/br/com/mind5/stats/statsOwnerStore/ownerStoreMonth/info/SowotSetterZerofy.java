package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowotSetterZerofy extends InfoSetterTemplate<SowotInfo> {
	
	@Override protected SowotInfo setAttrHook(SowotInfo recordInfo) {
		recordInfo.countStoreTotalMonth = 0;
		recordInfo.countStoreCreatedMonth = 0;
		recordInfo.countStoreCompletedMonth = 0;
		recordInfo.countStorePendingMonth = 0;
		recordInfo.countStoreTotalLastYear = 0;
		recordInfo.countStoreCreatedLastYear = 0;
		recordInfo.countStoreCompletedLastYear = 0;
		recordInfo.countStorePendingLastYear = 0;

		return recordInfo;
	}
}
