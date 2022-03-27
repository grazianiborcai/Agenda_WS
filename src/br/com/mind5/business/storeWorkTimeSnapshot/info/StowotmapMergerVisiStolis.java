package br.com.mind5.business.storeWorkTimeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StowotmapMergerVisiStolis extends InfoMergerVisitorTemplate<StowotmapInfo, StolisInfo> {

	@Override public boolean shouldMerge(StowotmapInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StowotmapInfo> merge(StowotmapInfo baseInfo, StolisInfo selectedInfo) {
		List<StowotmapInfo> results = new ArrayList<>();
		
		baseInfo.codTimezone = selectedInfo.codTimezone;
		
		results.add(baseInfo);
		return results;
	}
}
