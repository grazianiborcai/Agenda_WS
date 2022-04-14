package br.com.mind5.business.storeLunchTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class StuntmMergerVisiWeekday extends InfoMergerVisitorTemplate<StuntmInfo, WeekdayInfo> {

	@Override public boolean shouldMerge(StuntmInfo baseInfo, WeekdayInfo selectedInfo) {
		return (baseInfo.codWeekday == selectedInfo.codWeekday);
	}
	
	
	
	@Override public List<StuntmInfo> merge(StuntmInfo baseInfo, WeekdayInfo selectedInfo) {
		List<StuntmInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
