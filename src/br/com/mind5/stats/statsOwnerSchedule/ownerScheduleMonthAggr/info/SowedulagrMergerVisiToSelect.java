package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowedulagrMergerVisiToSelect extends InfoMergerVisitorTemplate<SowedulagrInfo, SowedulagrInfo> {

	@Override public boolean shouldMerge(SowedulagrInfo baseInfo, SowedulagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowedulagrInfo> merge(SowedulagrInfo baseInfo, SowedulagrInfo selectedInfo) {
		List<SowedulagrInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
