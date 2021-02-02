package br.com.mind5.business.calendarDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CalateVisiMergeToSelect extends InfoMergerVisitorTemplate<CalateInfo, CalateInfo> {

	@Override public boolean shouldMerge(CalateInfo baseInfo, CalateInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CalateInfo> merge(CalateInfo baseInfo, CalateInfo selectedInfo) {
		List<CalateInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
