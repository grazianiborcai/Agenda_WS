package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowedularchVisiMergeToSelect extends InfoMergerVisitorTemplate<SowedularchInfo, SowedularchInfo> {

	@Override public boolean shouldMerge(SowedularchInfo baseInfo, SowedularchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowedularchInfo> merge(SowedularchInfo baseInfo, SowedularchInfo selectedInfo) {
		List<SowedularchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
