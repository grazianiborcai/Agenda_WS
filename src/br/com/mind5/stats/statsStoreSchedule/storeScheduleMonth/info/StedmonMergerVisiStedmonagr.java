package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;

final class StedmonMergerVisiStedmonagr extends InfoMergerVisitorTemplate<StedmonInfo, StedmonagrInfo> {

	@Override public boolean shouldMerge(StedmonInfo baseInfo, StedmonagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.calmonth.equals(selectedInfo.calmonth));
	}
	
	
	
	@Override public List<StedmonInfo> merge(StedmonInfo baseInfo, StedmonagrInfo selectedInfo) {
		List<StedmonInfo> results = new ArrayList<>();
		
		StedmonInfo result = StedmonInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
