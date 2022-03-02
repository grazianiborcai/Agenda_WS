package br.com.mind5.stats.statsOwnerDashboard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;

final class SowashVisiMergeSowus extends InfoMergerVisitorTemplate<SowashInfo, SowusInfo> {

	@Override public boolean shouldMerge(SowashInfo baseInfo, SowusInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowashInfo> merge(SowashInfo baseInfo, SowusInfo selectedInfo) {
		List<SowashInfo> results = new ArrayList<>();
		
		baseInfo.sowuses.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
