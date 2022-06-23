package br.com.mind5.business.home.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;

final class HomeMergerVisiStorash extends InfoMergerVisitorTemplate<HomeInfo, StorashInfo> {

	@Override public boolean shouldMerge(HomeInfo baseInfo, StorashInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<HomeInfo> merge(HomeInfo baseInfo, StorashInfo selectedInfo) {
		List<HomeInfo> results = new ArrayList<>();
		
		baseInfo.storashData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
