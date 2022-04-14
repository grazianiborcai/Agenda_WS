package br.com.mind5.business.storeLunchTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StuntmMergerVisiStuntmap extends InfoMergerVisitorTemplate<StuntmInfo, StuntmapInfo> {

	@Override public boolean shouldMerge(StuntmInfo baseInfo, StuntmapInfo selectedInfo) {
		return (baseInfo.codOwner   == selectedInfo.codOwner &&
				baseInfo.codStore   == selectedInfo.codStore &&
				baseInfo.codWeekday == selectedInfo.codWeekday);
	}
	
	

	@Override public List<StuntmInfo> merge(StuntmInfo baseInfo, StuntmapInfo selectedInfo) {
		List<StuntmInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
