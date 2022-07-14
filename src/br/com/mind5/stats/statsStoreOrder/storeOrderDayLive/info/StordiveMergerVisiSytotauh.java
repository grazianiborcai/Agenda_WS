package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StordiveMergerVisiSytotauh extends InfoMergerVisitorTemplate<StordiveInfo, SytotauhInfo> {

	@Override public boolean shouldMerge(StordiveInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<StordiveInfo> merge(StordiveInfo baseInfo, SytotauhInfo selectedInfo) {
		List<StordiveInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
