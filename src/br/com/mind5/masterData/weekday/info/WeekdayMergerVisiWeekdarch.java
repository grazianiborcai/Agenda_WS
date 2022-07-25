package br.com.mind5.masterData.weekday.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;

final class WeekdayMergerVisiWeekdarch extends InfoMergerVisitorTemplate<WeekdayInfo, WeekdarchInfo> {

	@Override public boolean shouldMerge(WeekdayInfo baseInfo, WeekdarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<WeekdayInfo> merge(WeekdayInfo baseInfo, WeekdarchInfo selectedInfo) {
		List<WeekdayInfo> results = new ArrayList<>();
		
		WeekdayInfo result = WeekdayInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
