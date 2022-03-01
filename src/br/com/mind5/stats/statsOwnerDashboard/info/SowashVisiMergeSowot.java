package br.com.mind5.stats.statsOwnerDashboard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;

final class SowashVisiMergeSowot extends InfoMergerVisitorTemplate<SowashInfo, SowotInfo> {

	@Override public boolean shouldMerge(SowashInfo baseInfo, SowotInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowashInfo> merge(SowashInfo baseInfo, SowotInfo selectedInfo) {
		List<SowashInfo> results = new ArrayList<>();
		
		baseInfo.sowotes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
