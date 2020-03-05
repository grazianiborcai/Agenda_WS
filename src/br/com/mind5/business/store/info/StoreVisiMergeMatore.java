package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StoreVisiMergeMatore implements InfoMergerVisitorV3<StoreInfo, MatoreInfo> {
	
	@Override public List<StoreInfo> beforeMerge(List<StoreInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoreInfo baseInfo, MatoreInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StoreInfo> merge(StoreInfo baseInfo, MatoreInfo selectedInfo) {
		List<StoreInfo> results = new ArrayList<>();
		
		baseInfo.matores.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoreInfo> getUniquifier() {
		return new StoreUniquifier();
	}
}
