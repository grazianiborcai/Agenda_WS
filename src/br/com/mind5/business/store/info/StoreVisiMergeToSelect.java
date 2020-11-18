package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StoreVisiMergeToSelect extends InfoMergerVisitorTemplate<StoreInfo, StoreInfo> {
	
	@Override public List<StoreInfo> beforeMerge(List<StoreInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoreInfo baseInfo, StoreInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoreInfo> merge(StoreInfo baseInfo, StoreInfo selectedInfo) {
		List<StoreInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoreInfo> getUniquifier() {
		return new StoreUniquifier();
	}
}
