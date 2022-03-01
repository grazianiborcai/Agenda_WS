package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowordagrMergerVisiCalonth extends InfoMergerVisitorTemplate<SowordagrInfo, CalonthInfo> {

	@Override public boolean shouldMerge(SowordagrInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.calmonth.equals(selectedInfo.calmonth) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowordagrInfo> merge(SowordagrInfo baseInfo, CalonthInfo selectedInfo) {
		List<SowordagrInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
