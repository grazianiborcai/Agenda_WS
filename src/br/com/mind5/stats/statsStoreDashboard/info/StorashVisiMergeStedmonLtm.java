package br.com.mind5.stats.statsStoreDashboard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;

final class StorashVisiMergeStedmonLtm extends InfoMergerVisitorTemplate<StorashInfo, StedmonInfo> {

	@Override public boolean shouldMerge(StorashInfo baseInfo, StedmonInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore);
	}
	
	
	
	@Override public List<StorashInfo> merge(StorashInfo baseInfo, StedmonInfo selectedInfo) {
		List<StorashInfo> results = new ArrayList<>();
		
		baseInfo.stedmones.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
