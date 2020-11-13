package br.com.mind5.business.calendarWeekYear.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CaleekyVisiMergeCalate implements InfoMergerVisitor<CaleekyInfo, CalateInfo> {
	
	@Override public List<CaleekyInfo> beforeMerge(List<CaleekyInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CaleekyInfo baseInfo, CalateInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CaleekyInfo> merge(CaleekyInfo baseInfo, CalateInfo selectedInfo) {
		List<CaleekyInfo> results = new ArrayList<>();
		
		baseInfo.weekYear = selectedInfo.weekYear;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CaleekyInfo> getUniquifier() {
		return null;
	}
}
