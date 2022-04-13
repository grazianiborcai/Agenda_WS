package br.com.mind5.business.storeLunchTimeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class StuntmapMergerVisiWeekday extends InfoMergerVisitorTemplate<StuntmapInfo, WeekdayInfo> {

	@Override public boolean shouldMerge(StuntmapInfo baseInfo, WeekdayInfo selectedInfo) {
		return (baseInfo.codWeekday == selectedInfo.codWeekday);
	}
	
	
	
	@Override public List<StuntmapInfo> merge(StuntmapInfo baseInfo, WeekdayInfo selectedInfo) {
		List<StuntmapInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
