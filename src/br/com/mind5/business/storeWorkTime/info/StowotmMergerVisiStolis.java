package br.com.mind5.business.storeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StowotmMergerVisiStolis extends InfoMergerVisitorTemplate<StowotmInfo, StolisInfo> {

	@Override public boolean shouldMerge(StowotmInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StowotmInfo> merge(StowotmInfo baseInfo, StolisInfo selectedInfo) {
		List<StowotmInfo> results = new ArrayList<>();
		
		baseInfo.codTimezone = selectedInfo.codTimezone;
		
		results.add(baseInfo);
		return results;
	}
}
