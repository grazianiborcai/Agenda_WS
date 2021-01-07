package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StoreVisiMergeSotarch extends InfoMergerVisitorTemplate<StoreInfo, SotarchInfo> {

	@Override public boolean shouldMerge(StoreInfo baseInfo, SotarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoreInfo> merge(StoreInfo baseInfo, SotarchInfo selectedInfo) {
		List<StoreInfo> results = new ArrayList<>();
		
		StoreInfo result = StoreInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoreInfo> getUniquifier() {
		return new StoreUniquifier();
	}
}
