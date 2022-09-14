package br.com.mind5.business.employeeLunchTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class EmplutmMergerVisiWeekdayFallback extends InfoMergerVisitorTemplate<EmplutmInfo, WeekdayInfo> {

	@Override public boolean shouldMerge(EmplutmInfo baseInfo, WeekdayInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<EmplutmInfo> merge(EmplutmInfo baseInfo, WeekdayInfo selectedInfo) {
		List<EmplutmInfo> results = new ArrayList<>();
		
		baseInfo.codWeekday = selectedInfo.codWeekday;
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
