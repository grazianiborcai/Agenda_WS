package br.com.mind5.business.storeLunchTimeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StuntmapMergerVisiStolis extends InfoMergerVisitorTemplate<StuntmapInfo, StolisInfo> {

	@Override public boolean shouldMerge(StuntmapInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StuntmapInfo> merge(StuntmapInfo baseInfo, StolisInfo selectedInfo) {
		List<StuntmapInfo> results = new ArrayList<>();
		
		baseInfo.codTimezone = selectedInfo.codTimezone;
		
		results.add(baseInfo);
		return results;
	}
}
