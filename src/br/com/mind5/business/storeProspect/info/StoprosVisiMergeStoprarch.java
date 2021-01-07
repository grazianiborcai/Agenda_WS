package br.com.mind5.business.storeProspect.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoprosVisiMergeStoprarch extends InfoMergerVisitorTemplate<StoprosInfo, StoprarchInfo> {

	@Override public boolean shouldMerge(StoprosInfo baseInfo, StoprarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoprosInfo> merge(StoprosInfo baseInfo, StoprarchInfo selectedInfo) {
		List<StoprosInfo> results = new ArrayList<>();
		
		StoprosInfo result = StoprosInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
