package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SoweduliveMergerVisiToSelect extends InfoMergerVisitorTemplate<SoweduliveInfo, SoweduliveInfo> {

	@Override public boolean shouldMerge(SoweduliveInfo baseInfo, SoweduliveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SoweduliveInfo> merge(SoweduliveInfo baseInfo, SoweduliveInfo selectedInfo) {
		List<SoweduliveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
