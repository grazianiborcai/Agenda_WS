package br.com.mind5.business.home.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;

final class HomeMergerVisiSowash extends InfoMergerVisitorTemplate<HomeInfo, SowashInfo> {

	@Override public boolean shouldMerge(HomeInfo baseInfo, SowashInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<HomeInfo> merge(HomeInfo baseInfo, SowashInfo selectedInfo) {
		List<HomeInfo> results = new ArrayList<>();
		
		baseInfo.sowashData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
