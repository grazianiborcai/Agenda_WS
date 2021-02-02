package br.com.mind5.business.calendarDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CalateVisiMergeCalatarch extends InfoMergerVisitorTemplate<CalateInfo, CalatarchInfo> {

	@Override public boolean shouldMerge(CalateInfo baseInfo, CalatarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CalateInfo> merge(CalateInfo baseInfo, CalatarchInfo selectedInfo) {
		List<CalateInfo> results = new ArrayList<>();
		
		CalateInfo result = CalateInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
