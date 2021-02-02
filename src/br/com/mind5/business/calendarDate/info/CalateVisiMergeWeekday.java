package br.com.mind5.business.calendarDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class CalateVisiMergeWeekday extends InfoMergerVisitorTemplate<CalateInfo, WeekdayInfo> {

	@Override public boolean shouldMerge(CalateInfo baseInfo, WeekdayInfo selectedInfo) {
		return baseInfo.codWeekday == selectedInfo.codWeekday;
	}
	
	
	
	@Override public List<CalateInfo> merge(CalateInfo baseInfo, WeekdayInfo selectedInfo) {
		List<CalateInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
