package br.com.mind5.stats.statsStoreDashboard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;

final class StorashVisiMergeStedd extends InfoMergerVisitorTemplate<StorashInfo, SteddInfo> {

	@Override public boolean shouldMerge(StorashInfo baseInfo, SteddInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.calmonth.equals(selectedInfo.calmonth));
	}
	
	
	
	@Override public List<StorashInfo> merge(StorashInfo baseInfo, SteddInfo selectedInfo) {
		List<StorashInfo> results = new ArrayList<>();
		
		baseInfo.steddes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
