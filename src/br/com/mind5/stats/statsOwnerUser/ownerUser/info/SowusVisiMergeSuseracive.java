package br.com.mind5.stats.statsOwnerUser.ownerUser.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info.SowusiveInfo;

final class SowusVisiMergeSuseracive extends InfoMergerVisitorTemplate<SowusInfo, SowusiveInfo> {

	@Override public boolean shouldMerge(SowusInfo baseInfo, SowusiveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowusInfo> merge(SowusInfo baseInfo, SowusiveInfo selectedInfo) {
		List<SowusInfo> results = new ArrayList<>();
		
		SowusInfo result = SowusInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
