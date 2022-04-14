package br.com.mind5.business.storeLunchTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StuntmMergerVisiStolis extends InfoMergerVisitorTemplate<StuntmInfo, StolisInfo> {

	@Override public boolean shouldMerge(StuntmInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StuntmInfo> merge(StuntmInfo baseInfo, StolisInfo selectedInfo) {
		List<StuntmInfo> results = new ArrayList<>();
		
		baseInfo.codTimezone = selectedInfo.codTimezone;
		
		results.add(baseInfo);
		return results;
	}
}
