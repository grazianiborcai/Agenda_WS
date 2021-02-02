package br.com.mind5.business.calendarTimeStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CalimoreVisiMergeCalate extends InfoMergerVisitorTemplate<CalimoreInfo, CalateInfo> {

	@Override public boolean shouldMerge(CalimoreInfo baseInfo, CalateInfo selectedInfo) {
		return baseInfo.date.equals(selectedInfo.date);
	}
	
	
	
	@Override public List<CalimoreInfo> merge(CalimoreInfo baseInfo, CalateInfo selectedInfo) {
		List<CalimoreInfo> results = new ArrayList<>();
		
		baseInfo.codWeekday = selectedInfo.codWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
