package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.info.SowotiveInfo;

final class SowotMergerVisiSowotive extends InfoMergerVisitorTemplate<SowotInfo, SowotiveInfo> {

	@Override public boolean shouldMerge(SowotInfo baseInfo, SowotiveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowotInfo> merge(SowotInfo baseInfo, SowotiveInfo selectedInfo) {
		List<SowotInfo> results = new ArrayList<>();
		
		SowotInfo result = SowotInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
