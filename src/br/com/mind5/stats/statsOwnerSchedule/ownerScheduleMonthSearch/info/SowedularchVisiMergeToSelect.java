package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowedularchVisiMergeToSelect extends InfoMergerVisitorTemplate<SowedularchhInfo, SowedularchhInfo> {

	@Override public boolean shouldMerge(SowedularchhInfo baseInfo, SowedularchhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowedularchhInfo> merge(SowedularchhInfo baseInfo, SowedularchhInfo selectedInfo) {
		List<SowedularchhInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
