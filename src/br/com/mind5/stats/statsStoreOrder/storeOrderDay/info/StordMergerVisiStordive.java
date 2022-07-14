package br.com.mind5.stats.statsStoreOrder.storeOrderDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;

final class StordMergerVisiStordive extends InfoMergerVisitorTemplate<StordInfo, StordiveInfo> {

	@Override public boolean shouldMerge(StordInfo baseInfo, StordiveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.date.isEqual(selectedInfo.date));
	}
	
	
	
	@Override public List<StordInfo> merge(StordInfo baseInfo, StordiveInfo selectedInfo) {
		List<StordInfo> results = new ArrayList<>();
		
		StordInfo result = StordInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
