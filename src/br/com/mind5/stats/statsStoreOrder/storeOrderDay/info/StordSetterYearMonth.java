package br.com.mind5.stats.statsStoreOrder.storeOrderDay.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StordSetterYearMonth extends InfoSetterTemplate<StordInfo> {
	
	@Override protected StordInfo setAttrHook(StordInfo recordInfo) {
		recordInfo.year = Integer.parseInt(recordInfo.calmonth.substring(0,4));
		recordInfo.month = Integer.parseInt(recordInfo.calmonth.substring(4,6));

		return recordInfo;
	}
}
