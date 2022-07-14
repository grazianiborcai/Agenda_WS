package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoronagrMergerVisiCalonth extends InfoMergerVisitorTemplate<StoronagrInfo, CalonthInfo> {

	@Override public boolean shouldMerge(StoronagrInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.calmonth.equals(selectedInfo.calmonth) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StoronagrInfo> merge(StoronagrInfo baseInfo, CalonthInfo selectedInfo) {
		List<StoronagrInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
