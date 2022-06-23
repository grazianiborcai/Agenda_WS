package br.com.mind5.stats.statsStoreDashboard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StorashMergerVisiSytotauh extends InfoMergerVisitorTemplate<StorashInfo, SytotauhInfo> {

	@Override public boolean shouldMerge(StorashInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<StorashInfo> merge(StorashInfo baseInfo, SytotauhInfo selectedInfo) {
		List<StorashInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
