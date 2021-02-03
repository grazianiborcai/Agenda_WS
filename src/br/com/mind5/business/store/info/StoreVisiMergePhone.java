package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StoreVisiMergePhone extends InfoMergerVisitorTemplate<StoreInfo, PhoneInfo> {

	@Override public boolean shouldMerge(StoreInfo baseInfo, PhoneInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StoreInfo> merge(StoreInfo baseInfo, PhoneInfo selectedInfo) {
		List<StoreInfo> results = new ArrayList<>();
		
		baseInfo.phones.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StoreInfo> uniquifyHook(List<StoreInfo> results) {
		InfoUniquifier<StoreInfo> uniquifier = new StoreUniquifier();		
		return uniquifier.uniquify(results);
	}
}
