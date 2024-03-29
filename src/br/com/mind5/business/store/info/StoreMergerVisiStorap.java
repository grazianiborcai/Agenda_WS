package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerVisiStorap extends InfoMergerVisitorTemplate<StoreInfo, StorapInfo> {

	@Override public boolean shouldMerge(StoreInfo baseInfo, StorapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StoreInfo> merge(StoreInfo baseInfo, StorapInfo selectedInfo) {
		List<StoreInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StoreInfo> uniquifyHook(List<StoreInfo> results) {
		InfoUniquifier<StoreInfo> uniquifier = new StoreUniquifier();		
		return uniquifier.uniquify(results);
	}
}
