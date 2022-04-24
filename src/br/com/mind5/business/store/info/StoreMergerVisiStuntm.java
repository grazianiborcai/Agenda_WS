package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerVisiStuntm extends InfoMergerVisitorTemplate<StoreInfo, StuntmInfo> {

	@Override public boolean shouldMerge(StoreInfo baseInfo, StuntmInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StoreInfo> merge(StoreInfo baseInfo, StuntmInfo selectedInfo) {
		List<StoreInfo> results = new ArrayList<>();
		
		baseInfo.stuntmes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StoreInfo> uniquifyHook(List<StoreInfo> results) {
		InfoUniquifier<StoreInfo> uniquifier = new StoreUniquifier();		
		return uniquifier.uniquify(results);
	}
}
