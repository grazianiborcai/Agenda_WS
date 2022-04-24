package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerVisiStowotm extends InfoMergerVisitorTemplate<StoreInfo, StowotmInfo> {

	@Override public boolean shouldMerge(StoreInfo baseInfo, StowotmInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StoreInfo> merge(StoreInfo baseInfo, StowotmInfo selectedInfo) {
		List<StoreInfo> results = new ArrayList<>();
		
		baseInfo.stowotmes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StoreInfo> uniquifyHook(List<StoreInfo> results) {
		InfoUniquifier<StoreInfo> uniquifier = new StoreUniquifier();		
		return uniquifier.uniquify(results);
	}
}
