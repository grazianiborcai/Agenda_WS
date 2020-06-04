package br.com.mind5.business.calendarWeekYear.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CaleekyVisiMergeToSelect implements InfoMergerVisitorV3<CaleekyInfo, CaleekyInfo> {
	
	@Override public List<CaleekyInfo> beforeMerge(List<CaleekyInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<CaleekyInfo> getUniquifier() {
		return null;
	}
}
