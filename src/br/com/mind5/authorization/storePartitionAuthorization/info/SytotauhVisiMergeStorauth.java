package br.com.mind5.authorization.storePartitionAuthorization.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SytotauhVisiMergeStorauth extends InfoMergerVisitorTemplate<SytotauhInfo, StorauthInfo> {

	@Override public boolean shouldMerge(SytotauhInfo baseInfo, StorauthInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<SytotauhInfo> merge(SytotauhInfo baseInfo, StorauthInfo selectedInfo) {
		List<SytotauhInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
