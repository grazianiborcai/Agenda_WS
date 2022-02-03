package br.com.mind5.stats.statsStoreAccount.storeAccount.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StoracSetterZerofy extends InfoSetterTemplate<StoracInfo> {
	
	@Override protected StoracInfo setAttrHook(StoracInfo recordInfo) {
		recordInfo.countStoreMonth = 0;
		recordInfo.countStoreCompletedMonth = 0;
		recordInfo.countStorePendingMonth = 0;
		recordInfo.countStoreMonthLastYear = 0;
		recordInfo.countStoreCompletedMonthLastYear = 0;
		recordInfo.countStorePendingMonthLastYear = 0;
		recordInfo.countStoreVar = 0;
		recordInfo.countStoreCompletedVar = 0;
		recordInfo.countStorePendingVar = 0;
		recordInfo.countStoreCumulative = 0;
		recordInfo.countStoreCompletedCumulative = 0;
		recordInfo.countStorePendingCumulative = 0;

		return recordInfo;
	}
}
