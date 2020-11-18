package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorapVisiMergeToSelect extends InfoMergerVisitorTemplate<StorapInfo, StorapInfo> {

	@Override public List<StorapInfo> beforeMerge(List<StorapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorapInfo baseInfo, StorapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StorapInfo> merge(StorapInfo baseInfo, StorapInfo selectedInfo) {
		List<StorapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorapInfo> getUniquifier() {
		return new StorapUniquifier();
	}
}
