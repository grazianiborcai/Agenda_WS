package br.com.mind5.business.calendarTimeEmployee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CalimempVisiMergeCalate implements InfoMergerVisitorV3<CalimempInfo, CalateInfo> {
	
	@Override public List<CalimempInfo> beforeMerge(List<CalimempInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CalimempInfo baseInfo, CalateInfo selectedInfo) {
		return baseInfo.date.equals(selectedInfo.date);
	}
	
	
	
	@Override public List<CalimempInfo> merge(CalimempInfo baseInfo, CalateInfo selectedInfo) {
		List<CalimempInfo> results = new ArrayList<>();
		
		baseInfo.codWeekday = selectedInfo.codWeekday;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CalimempInfo> getUniquifier() {
		return null;
	}
}
