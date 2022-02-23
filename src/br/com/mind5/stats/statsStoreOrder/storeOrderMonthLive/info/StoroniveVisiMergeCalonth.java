package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoroniveVisiMergeCalonth extends InfoMergerVisitorTemplate<StoroniveInfo, CalonthInfo> {

	@Override public boolean shouldMerge(StoroniveInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.calmonth.equals(selectedInfo.calmonth) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StoroniveInfo> merge(StoroniveInfo baseInfo, CalonthInfo selectedInfo) {
		List<StoroniveInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
