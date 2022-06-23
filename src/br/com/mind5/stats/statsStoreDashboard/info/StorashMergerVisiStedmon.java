package br.com.mind5.stats.statsStoreDashboard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;

final class StorashMergerVisiStedmon extends InfoMergerVisitorTemplate<StorashInfo, StedmonInfo> {

	@Override public boolean shouldMerge(StorashInfo baseInfo, StedmonInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.calmonth.equals(selectedInfo.calmonth));
	}
	
	
	
	@Override public List<StorashInfo> merge(StorashInfo baseInfo, StedmonInfo selectedInfo) {
		List<StorashInfo> results = new ArrayList<>();
		
		baseInfo.stedmonData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
