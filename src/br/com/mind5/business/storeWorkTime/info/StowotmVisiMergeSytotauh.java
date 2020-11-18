package br.com.mind5.business.storeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StowotmVisiMergeSytotauh extends InfoMergerVisitorTemplate<StowotmInfo, SytotauhInfo> {
	
	@Override public List<StowotmInfo> beforeMerge(List<StowotmInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StowotmInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<StowotmInfo> merge(StowotmInfo baseInfo, SytotauhInfo selectedInfo) {
		List<StowotmInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StowotmInfo> getUniquifier() {
		return null;
	}
}
