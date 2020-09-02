package br.com.mind5.business.calendarCatalogueData.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CalguataVisiMergeCalate implements InfoMergerVisitorV3<CalguataInfo, CalateInfo> {
	
	@Override public List<CalguataInfo> beforeMerge(List<CalguataInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CalguataInfo baseInfo, CalateInfo selectedInfo) {
		return (baseInfo.year  == selectedInfo.year && 
				baseInfo.month == selectedInfo.month	);
	}
	
	
	
	@Override public List<CalguataInfo> merge(CalguataInfo baseInfo, CalateInfo selectedInfo) {
		List<CalguataInfo> results = new ArrayList<>();
		
		baseInfo.date = selectedInfo.date;
		baseInfo.day = selectedInfo.day;
		baseInfo.codWeekday = selectedInfo.codWeekday;
		baseInfo.codMoonPhase = selectedInfo.codMoonPhase;
		
		results.add(baseInfo);
		return results;
	}
	
	
		
	@Override public InfoUniquifier<CalguataInfo> getUniquifier() {
		return null;
	}
}
