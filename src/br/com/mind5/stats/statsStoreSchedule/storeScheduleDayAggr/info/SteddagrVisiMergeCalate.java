package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SteddagrVisiMergeCalate extends InfoMergerVisitorTemplate<SteddagrInfo, CalateInfo> {

	@Override public boolean shouldMerge(SteddagrInfo baseInfo, CalateInfo selectedInfo) {
		return (baseInfo.date.isEqual(selectedInfo.date) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SteddagrInfo> merge(SteddagrInfo baseInfo, CalateInfo selectedInfo) {
		List<SteddagrInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		baseInfo.codWeekday = selectedInfo.codWeekday;
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
