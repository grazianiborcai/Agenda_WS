package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedineMergerVisiCalate extends InfoMergerVisitorTemplate<SchedineInfo, CalateInfo> {

	@Override public boolean shouldMerge(SchedineInfo baseInfo, CalateInfo selectedInfo) {
		return (baseInfo.date.equals(selectedInfo.date));
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, CalateInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		baseInfo.codWeekday = selectedInfo.codWeekday;
		baseInfo.day = selectedInfo.day;
		baseInfo.month = selectedInfo.month;
		baseInfo.year = selectedInfo.year;
		baseInfo.weekMonth = selectedInfo.weekMonth;
		baseInfo.weekYear = selectedInfo.weekYear;
		baseInfo.quarter = selectedInfo.quarter;
		
		results.add(baseInfo);
		return results;
	}
}
