package br.com.mind5.stats.statsStoreAccount.storeAccount.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;

final class StoracVisiMergeStoracive extends InfoMergerVisitorTemplate<StoracInfo, StoraciveInfo> {

	@Override public boolean shouldMerge(StoracInfo baseInfo, StoraciveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoracInfo> merge(StoracInfo baseInfo, StoraciveInfo selectedInfo) {
		List<StoracInfo> results = new ArrayList<>();
		
		StoracInfo result = StoracInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
