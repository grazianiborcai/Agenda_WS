package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;

final class StedmonVisiMergeStedmonive extends InfoMergerVisitorTemplate<StedmonInfo, StedmoniveInfo> {

	@Override public boolean shouldMerge(StedmonInfo baseInfo, StedmoniveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.calmonth.equals(selectedInfo.calmonth));
	}
	
	
	
	@Override public List<StedmonInfo> merge(StedmonInfo baseInfo, StedmoniveInfo selectedInfo) {
		List<StedmonInfo> results = new ArrayList<>();
		
		StedmonInfo result = StedmonInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
