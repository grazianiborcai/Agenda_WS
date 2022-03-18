package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StedmonagrMergerVisiCalonth extends InfoMergerVisitorTemplate<StedmonagrInfo, CalonthInfo> {

	@Override public boolean shouldMerge(StedmonagrInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.calmonth.equals(selectedInfo.calmonth) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StedmonagrInfo> merge(StedmonagrInfo baseInfo, CalonthInfo selectedInfo) {
		List<StedmonagrInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
