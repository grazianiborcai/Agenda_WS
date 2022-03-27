package br.com.mind5.business.storeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSnapshot.info.StowotmapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StowotmMergerVisiStowotmap extends InfoMergerVisitorTemplate<StowotmInfo, StowotmapInfo> {

	@Override public boolean shouldMerge(StowotmInfo baseInfo, StowotmapInfo selectedInfo) {
		return (baseInfo.codOwner   == selectedInfo.codOwner &&
				baseInfo.codStore   == selectedInfo.codStore &&
				baseInfo.codWeekday == selectedInfo.codWeekday);
	}
	
	

	@Override public List<StowotmInfo> merge(StowotmInfo baseInfo, StowotmapInfo selectedInfo) {
		List<StowotmInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
