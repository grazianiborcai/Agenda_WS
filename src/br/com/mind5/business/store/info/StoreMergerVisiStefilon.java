package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;

final class StoreMergerVisiStefilon extends InfoMergerVisitorTemplate<StoreInfo, StefilonInfo> {

	@Override public boolean shouldMerge(StoreInfo baseInfo, StefilonInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StoreInfo> merge(StoreInfo baseInfo, StefilonInfo selectedInfo) {
		List<StoreInfo> results = new ArrayList<>();
		
		baseInfo.stefilonData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StoreInfo> uniquifyHook(List<StoreInfo> results) {
		InfoUniquifier<StoreInfo> uniquifier = new StoreUniquifier();		
		return uniquifier.uniquify(results);
	}
}
