package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SteddVisiMergeCalate extends InfoMergerVisitorTemplate<SteddInfo, CalateInfo> {

	@Override public boolean shouldMerge(SteddInfo baseInfo, CalateInfo selectedInfo) {
		return (baseInfo.year  == selectedInfo.year	&&
				baseInfo.month == selectedInfo.month);
	}
	
	
	
	@Override public List<SteddInfo> merge(SteddInfo baseInfo, CalateInfo selectedInfo) {
		List<SteddInfo> results = new ArrayList<>();
		
		baseInfo.day = selectedInfo.day;
		baseInfo.date = selectedInfo.date;
		baseInfo.calmonth = selectedInfo.calmonth;
		baseInfo.txtMonth = selectedInfo.txtMonth;
		baseInfo.codWeekday = selectedInfo.codWeekday;
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
