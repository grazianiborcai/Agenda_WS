package br.com.mind5.business.storeWorkTimeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class StowotmapMergerVisiWeekday extends InfoMergerVisitorTemplate<StowotmapInfo, WeekdayInfo> {

	@Override public boolean shouldMerge(StowotmapInfo baseInfo, WeekdayInfo selectedInfo) {
		return (baseInfo.codWeekday == selectedInfo.codWeekday);
	}
	
	
	
	@Override public List<StowotmapInfo> merge(StowotmapInfo baseInfo, WeekdayInfo selectedInfo) {
		List<StowotmapInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
