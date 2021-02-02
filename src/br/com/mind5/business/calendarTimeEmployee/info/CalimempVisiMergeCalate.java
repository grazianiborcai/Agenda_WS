package br.com.mind5.business.calendarTimeEmployee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CalimempVisiMergeCalate extends InfoMergerVisitorTemplate<CalimempInfo, CalateInfo> {

	@Override public boolean shouldMerge(CalimempInfo baseInfo, CalateInfo selectedInfo) {
		return baseInfo.date.equals(selectedInfo.date);
	}
	
	
	
	@Override public List<CalimempInfo> merge(CalimempInfo baseInfo, CalateInfo selectedInfo) {
		List<CalimempInfo> results = new ArrayList<>();
		
		baseInfo.codWeekday = selectedInfo.codWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
