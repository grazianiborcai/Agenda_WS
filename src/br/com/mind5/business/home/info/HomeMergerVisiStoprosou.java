package br.com.mind5.business.home.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspectCounter.info.StoprosouInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class HomeMergerVisiStoprosou extends InfoMergerVisitorTemplate<HomeInfo, StoprosouInfo> {

	@Override public boolean shouldMerge(HomeInfo baseInfo, StoprosouInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<HomeInfo> merge(HomeInfo baseInfo, StoprosouInfo selectedInfo) {
		List<HomeInfo> results = new ArrayList<>();
		
		baseInfo.stoprosou = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
