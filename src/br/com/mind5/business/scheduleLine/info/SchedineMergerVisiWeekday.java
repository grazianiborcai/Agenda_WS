package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class SchedineMergerVisiWeekday extends InfoMergerVisitorTemplate<SchedineInfo, WeekdayInfo> {

	@Override public boolean shouldMerge(SchedineInfo baseInfo, WeekdayInfo selectedInfo) {
		return (baseInfo.codWeekday == selectedInfo.codWeekday && 
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, WeekdayInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
