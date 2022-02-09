package br.com.mind5.stats.statsOwnerDashboard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info.SowedulInfo;

final class SowashVisiMergeSowedul extends InfoMergerVisitorTemplate<SowashInfo, SowedulInfo> {

	@Override public boolean shouldMerge(SowashInfo baseInfo, SowedulInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowashInfo> merge(SowashInfo baseInfo, SowedulInfo selectedInfo) {
		List<SowashInfo> results = new ArrayList<>();
		
		baseInfo.sowedules.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
