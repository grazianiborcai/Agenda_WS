package br.com.mind5.business.calendarDateAvailability.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CalatityMergerVisiCalate extends InfoMergerVisitorTemplate<CalatityInfo, CalateInfo> {

	@Override public boolean shouldMerge(CalatityInfo baseInfo, CalateInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CalatityInfo> merge(CalatityInfo baseInfo, CalateInfo selectedInfo) {
		List<CalatityInfo> results = new ArrayList<>();
		
		CalatityInfo result = CalatityInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
