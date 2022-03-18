package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SteddiveMergerVisiSytotauh extends InfoMergerVisitorTemplate<SteddiveInfo, SytotauhInfo> {

	@Override public boolean shouldMerge(SteddiveInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<SteddiveInfo> merge(SteddiveInfo baseInfo, SytotauhInfo selectedInfo) {
		List<SteddiveInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
