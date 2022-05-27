package br.com.mind5.business.storeProspectCounter.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoprosouMergerVisiStopros extends InfoMergerVisitorTemplate<StoprosouInfo, StoprosInfo> {

	@Override public boolean shouldMerge(StoprosouInfo baseInfo, StoprosInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoprosouInfo> merge(StoprosouInfo baseInfo, StoprosInfo selectedInfo) {
		List<StoprosouInfo> results = new ArrayList<>();
		
		baseInfo.stoproses.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
