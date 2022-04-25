package br.com.mind5.business.employeeLunchTimeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class EmplutmapMergerVisiWeekday extends InfoMergerVisitorTemplate<EmplutmapInfo, WeekdayInfo> {
	
	@Override public boolean shouldMerge(EmplutmapInfo baseInfo, WeekdayInfo selectedInfo) {
		return (baseInfo.codWeekday == selectedInfo.codWeekday		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage)		);
	}
	
	
	
	@Override public List<EmplutmapInfo> merge(EmplutmapInfo baseInfo, WeekdayInfo selectedInfo) {
		List<EmplutmapInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
