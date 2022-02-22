package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StedmonagrVisiMergeToSelect extends InfoMergerVisitorTemplate<StedmonagrInfo, StedmonagrInfo> {

	@Override public boolean shouldMerge(StedmonagrInfo baseInfo, StedmonagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StedmonagrInfo> merge(StedmonagrInfo baseInfo, StedmonagrInfo selectedInfo) {
		List<StedmonagrInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
