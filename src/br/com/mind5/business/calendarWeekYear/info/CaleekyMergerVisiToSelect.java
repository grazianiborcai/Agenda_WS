package br.com.mind5.business.calendarWeekYear.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CaleekyMergerVisiToSelect extends InfoMergerVisitorTemplate<CaleekyInfo, CaleekyInfo> {

	@Override public boolean shouldMerge(CaleekyInfo baseInfo, CaleekyInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CaleekyInfo> merge(CaleekyInfo baseInfo, CaleekyInfo selectedInfo) {
		List<CaleekyInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
