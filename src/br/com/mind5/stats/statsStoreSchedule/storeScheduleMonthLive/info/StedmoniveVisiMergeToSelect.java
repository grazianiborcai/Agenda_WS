package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StedmoniveVisiMergeToSelect extends InfoMergerVisitorTemplate<StedmoniveInfo, StedmoniveInfo> {

	@Override public boolean shouldMerge(StedmoniveInfo baseInfo, StedmoniveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StedmoniveInfo> merge(StedmoniveInfo baseInfo, StedmoniveInfo selectedInfo) {
		List<StedmoniveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
