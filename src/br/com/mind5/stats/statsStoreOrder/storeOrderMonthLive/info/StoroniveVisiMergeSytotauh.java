package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoroniveVisiMergeSytotauh extends InfoMergerVisitorTemplate<StoroniveInfo, SytotauhInfo> {

	@Override public boolean shouldMerge(StoroniveInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<StoroniveInfo> merge(StoroniveInfo baseInfo, SytotauhInfo selectedInfo) {
		List<StoroniveInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
