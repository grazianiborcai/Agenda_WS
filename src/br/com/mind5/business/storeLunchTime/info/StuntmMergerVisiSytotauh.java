package br.com.mind5.business.storeLunchTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StuntmMergerVisiSytotauh extends InfoMergerVisitorTemplate<StuntmInfo, SytotauhInfo> {

	@Override public boolean shouldMerge(StuntmInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<StuntmInfo> merge(StuntmInfo baseInfo, SytotauhInfo selectedInfo) {
		List<StuntmInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
