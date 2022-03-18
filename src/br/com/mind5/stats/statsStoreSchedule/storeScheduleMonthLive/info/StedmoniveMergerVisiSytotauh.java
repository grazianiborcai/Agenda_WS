package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StedmoniveMergerVisiSytotauh extends InfoMergerVisitorTemplate<StedmoniveInfo, SytotauhInfo> {

	@Override public boolean shouldMerge(StedmoniveInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<StedmoniveInfo> merge(StedmoniveInfo baseInfo, SytotauhInfo selectedInfo) {
		List<StedmoniveInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
