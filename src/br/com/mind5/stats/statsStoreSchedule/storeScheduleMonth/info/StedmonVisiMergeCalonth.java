package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StedmonVisiMergeCalonth extends InfoMergerVisitorTemplate<StedmonInfo, CalonthInfo> {

	@Override public boolean shouldMerge(StedmonInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StedmonInfo> merge(StedmonInfo baseInfo, CalonthInfo selectedInfo) {
		List<StedmonInfo> results = new ArrayList<>();
		
		baseInfo.calmonth = selectedInfo.calmonth;
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
