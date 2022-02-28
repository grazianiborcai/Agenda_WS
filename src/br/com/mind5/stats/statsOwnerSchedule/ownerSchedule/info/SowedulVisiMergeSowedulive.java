package br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;

final class SowedulVisiMergeSowedulive extends InfoMergerVisitorTemplate<SowedulInfo, SoweduliveInfo> {

	@Override public boolean shouldMerge(SowedulInfo baseInfo, SoweduliveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowedulInfo> merge(SowedulInfo baseInfo, SoweduliveInfo selectedInfo) {
		List<SowedulInfo> results = new ArrayList<>();
		
		SowedulInfo result = SowedulInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
