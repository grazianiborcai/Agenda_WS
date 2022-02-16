package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SteddiveVisiMergeCalate extends InfoMergerVisitorTemplate<SteddiveInfo, CalateInfo> {

	@Override public boolean shouldMerge(SteddiveInfo baseInfo, CalateInfo selectedInfo) {
		return (baseInfo.date.isEqual(selectedInfo.date) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SteddiveInfo> merge(SteddiveInfo baseInfo, CalateInfo selectedInfo) {
		List<SteddiveInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		baseInfo.codWeekday = selectedInfo.codWeekday;
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
