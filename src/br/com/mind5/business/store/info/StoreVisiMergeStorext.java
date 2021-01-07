package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StoreVisiMergeStorext extends InfoMergerVisitorTemplate<StoreInfo, StorextInfo> {

	@Override public boolean shouldMerge(StoreInfo baseInfo, StorextInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StoreInfo> merge(StoreInfo baseInfo, StorextInfo selectedInfo) {
		List<StoreInfo> results = new ArrayList<>();
		
		baseInfo.storextes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoreInfo> getUniquifier() {
		return new StoreUniquifier();
	}
}
