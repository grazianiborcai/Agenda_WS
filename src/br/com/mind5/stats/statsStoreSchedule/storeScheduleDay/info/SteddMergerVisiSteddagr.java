package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;

final class SteddMergerVisiSteddagr extends InfoMergerVisitorTemplate<SteddInfo, SteddagrInfo> {

	@Override public boolean shouldMerge(SteddInfo baseInfo, SteddagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.date.isEqual(selectedInfo.date));
	}
	
	
	
	@Override public List<SteddInfo> merge(SteddInfo baseInfo, SteddagrInfo selectedInfo) {
		List<SteddInfo> results = new ArrayList<>();
		
		SteddInfo result = SteddInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
