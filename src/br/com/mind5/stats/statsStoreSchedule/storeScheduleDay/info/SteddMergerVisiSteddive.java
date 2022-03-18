package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;

final class SteddMergerVisiSteddive extends InfoMergerVisitorTemplate<SteddInfo, SteddiveInfo> {

	@Override public boolean shouldMerge(SteddInfo baseInfo, SteddiveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.date.isEqual(selectedInfo.date));
	}
	
	
	
	@Override public List<SteddInfo> merge(SteddInfo baseInfo, SteddiveInfo selectedInfo) {
		List<SteddInfo> results = new ArrayList<>();
		
		SteddInfo result = SteddInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
