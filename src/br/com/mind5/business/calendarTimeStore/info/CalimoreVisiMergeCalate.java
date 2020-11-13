package br.com.mind5.business.calendarTimeStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CalimoreVisiMergeCalate implements InfoMergerVisitor<CalimoreInfo, CalateInfo> {
	
	@Override public List<CalimoreInfo> beforeMerge(List<CalimoreInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CalimoreInfo baseInfo, CalateInfo selectedInfo) {
		return baseInfo.date.equals(selectedInfo.date);
	}
	
	
	
	@Override public List<CalimoreInfo> merge(CalimoreInfo baseInfo, CalateInfo selectedInfo) {
		List<CalimoreInfo> results = new ArrayList<>();
		
		baseInfo.codWeekday = selectedInfo.codWeekday;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CalimoreInfo> getUniquifier() {
		return null;
	}
}
