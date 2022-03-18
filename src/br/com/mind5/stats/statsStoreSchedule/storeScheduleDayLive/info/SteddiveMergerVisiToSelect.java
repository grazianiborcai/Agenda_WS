package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SteddiveMergerVisiToSelect extends InfoMergerVisitorTemplate<SteddiveInfo, SteddiveInfo> {

	@Override public boolean shouldMerge(SteddiveInfo baseInfo, SteddiveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SteddiveInfo> merge(SteddiveInfo baseInfo, SteddiveInfo selectedInfo) {
		List<SteddiveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
