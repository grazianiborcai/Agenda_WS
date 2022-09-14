package br.com.mind5.business.storeLunchTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class StuntmMergerVisiWeekdayFallback extends InfoMergerVisitorTemplate<StuntmInfo, WeekdayInfo> {

	@Override public boolean shouldMerge(StuntmInfo baseInfo, WeekdayInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<StuntmInfo> merge(StuntmInfo baseInfo, WeekdayInfo selectedInfo) {
		List<StuntmInfo> results = new ArrayList<>();
		
		baseInfo.codWeekday = selectedInfo.codWeekday;
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
