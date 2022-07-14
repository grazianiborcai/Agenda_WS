package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoronMergerVisiCalonth extends InfoMergerVisitorTemplate<StoronInfo, CalonthInfo> {

	@Override public boolean shouldMerge(StoronInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StoronInfo> merge(StoronInfo baseInfo, CalonthInfo selectedInfo) {
		List<StoronInfo> results = new ArrayList<>();
		
		baseInfo.calmonth = selectedInfo.calmonth;
		baseInfo.month = selectedInfo.month;
		baseInfo.year = selectedInfo.year;
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
