package br.com.mind5.masterData.weekday.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;

final class WeekdayVisiMergeWeekdarch implements InfoMergerVisitor<WeekdayInfo, WeekdarchInfo> {
	
	@Override public List<WeekdayInfo> beforeMerge(List<WeekdayInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(WeekdayInfo baseInfo, WeekdarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<WeekdayInfo> merge(WeekdayInfo baseInfo, WeekdarchInfo selectedInfo) {
		List<WeekdayInfo> results = new ArrayList<>();
		
		WeekdayInfo result = WeekdayInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<WeekdayInfo> getUniquifier() {
		return null;
	}
}
