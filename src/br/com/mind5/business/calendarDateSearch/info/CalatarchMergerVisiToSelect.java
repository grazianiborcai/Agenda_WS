package br.com.mind5.business.calendarDateSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CalatarchMergerVisiToSelect extends InfoMergerVisitorTemplate<CalatarchInfo, CalatarchInfo> {

	@Override public boolean shouldMerge(CalatarchInfo baseInfo, CalatarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CalatarchInfo> merge(CalatarchInfo baseInfo, CalatarchInfo selectedInfo) {
		List<CalatarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
