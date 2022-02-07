package br.com.mind5.stats.statsOwnerStore.ownerStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerStore.storeAccountLive.info.StoraciveInfo;

final class SowotVisiMergeStoracive extends InfoMergerVisitorTemplate<SowotInfo, StoraciveInfo> {

	@Override public boolean shouldMerge(SowotInfo baseInfo, StoraciveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowotInfo> merge(SowotInfo baseInfo, StoraciveInfo selectedInfo) {
		List<SowotInfo> results = new ArrayList<>();
		
		SowotInfo result = SowotInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
