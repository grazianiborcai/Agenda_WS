package br.com.mind5.business.storeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class StowotmVisiMergeWeekday extends InfoMergerVisitorTemplate<StowotmInfo, WeekdayInfo> {

	@Override public boolean shouldMerge(StowotmInfo baseInfo, WeekdayInfo selectedInfo) {
		return (baseInfo.codWeekday == selectedInfo.codWeekday);
	}
	
	
	
	@Override public List<StowotmInfo> merge(StowotmInfo baseInfo, WeekdayInfo selectedInfo) {
		List<StowotmInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
