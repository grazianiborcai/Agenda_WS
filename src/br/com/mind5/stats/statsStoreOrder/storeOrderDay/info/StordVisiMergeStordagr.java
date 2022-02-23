package br.com.mind5.stats.statsStoreOrder.storeOrderDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;

final class StordVisiMergeStordagr extends InfoMergerVisitorTemplate<StordInfo, StordagrInfo> {

	@Override public boolean shouldMerge(StordInfo baseInfo, StordagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.date.isEqual(selectedInfo.date));
	}
	
	
	
	@Override public List<StordInfo> merge(StordInfo baseInfo, StordagrInfo selectedInfo) {
		List<StordInfo> results = new ArrayList<>();
		
		StordInfo result = StordInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
