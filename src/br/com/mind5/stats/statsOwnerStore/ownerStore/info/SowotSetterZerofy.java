package br.com.mind5.stats.statsOwnerStore.ownerStore.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowotSetterZerofy extends InfoSetterTemplate<SowotInfo> {
	
	@Override protected SowotInfo setAttrHook(SowotInfo recordInfo) {
		recordInfo.countStoreCreatedMonth = 0;
		recordInfo.countStoreCompletedMonth = 0;
		recordInfo.countStorePendingMonth = 0;
		recordInfo.countStoreCreatedMonthLastYear = 0;
		recordInfo.countStoreCompletedMonthLastYear = 0;
		recordInfo.countStorePendingMonthLastYear = 0;
		recordInfo.countStoreCreatedVar = 0;
		recordInfo.countStoreCompletedVar = 0;
		recordInfo.countStorePendingVar = 0;
		recordInfo.countStoreCreatedCumulative = 0;
		recordInfo.countStoreCompletedCumulative = 0;
		recordInfo.countStorePendingCumulative = 0;

		return recordInfo;
	}
}
