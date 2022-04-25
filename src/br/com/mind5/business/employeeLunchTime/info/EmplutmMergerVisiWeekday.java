package br.com.mind5.business.employeeLunchTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class EmplutmMergerVisiWeekday extends InfoMergerVisitorTemplate<EmplutmInfo, WeekdayInfo> {
	
	@Override public boolean shouldMerge(EmplutmInfo baseInfo, WeekdayInfo selectedInfo) {
		return (baseInfo.codWeekday == selectedInfo.codWeekday		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage)		);
	}
	
	
	
	@Override public List<EmplutmInfo> merge(EmplutmInfo baseInfo, WeekdayInfo selectedInfo) {
		List<EmplutmInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
