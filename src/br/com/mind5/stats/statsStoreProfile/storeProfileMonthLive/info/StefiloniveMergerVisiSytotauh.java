package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StefiloniveMergerVisiSytotauh extends InfoMergerVisitorTemplate<StefiloniveInfo, SytotauhInfo> {

	@Override public boolean shouldMerge(StefiloniveInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<StefiloniveInfo> merge(StefiloniveInfo baseInfo, SytotauhInfo selectedInfo) {
		List<StefiloniveInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
