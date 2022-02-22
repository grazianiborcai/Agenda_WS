package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StedmoniveVisiMergeCalonth extends InfoMergerVisitorTemplate<StedmoniveInfo, CalonthInfo> {

	@Override public boolean shouldMerge(StedmoniveInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.calmonth.equals(selectedInfo.calmonth) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StedmoniveInfo> merge(StedmoniveInfo baseInfo, CalonthInfo selectedInfo) {
		List<StedmoniveInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
