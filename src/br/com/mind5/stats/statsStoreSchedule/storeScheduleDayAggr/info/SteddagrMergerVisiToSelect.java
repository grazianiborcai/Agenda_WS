package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SteddagrMergerVisiToSelect extends InfoMergerVisitorTemplate<SteddagrInfo, SteddagrInfo> {

	@Override public boolean shouldMerge(SteddagrInfo baseInfo, SteddagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SteddagrInfo> merge(SteddagrInfo baseInfo, SteddagrInfo selectedInfo) {
		List<SteddagrInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
