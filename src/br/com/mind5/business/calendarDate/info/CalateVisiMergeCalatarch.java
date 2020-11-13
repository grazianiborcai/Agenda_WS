package br.com.mind5.business.calendarDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CalateVisiMergeCalatarch implements InfoMergerVisitor<CalateInfo, CalatarchInfo> {
	
	@Override public List<CalateInfo> beforeMerge(List<CalateInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CalateInfo baseInfo, CalatarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CalateInfo> merge(CalateInfo baseInfo, CalatarchInfo selectedInfo) {
		List<CalateInfo> results = new ArrayList<>();
		
		CalateInfo result = CalateInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CalateInfo> getUniquifier() {
		return null;
	}
}
