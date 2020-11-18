package br.com.mind5.business.storeTextSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorextsnapVisiMergeToSelect extends InfoMergerVisitorTemplate<StorextsnapInfo, StorextsnapInfo> {

	@Override public List<StorextsnapInfo> beforeMerge(List<StorextsnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorextsnapInfo baseInfo, StorextsnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StorextsnapInfo> merge(StorextsnapInfo baseInfo, StorextsnapInfo selectedInfo) {
		List<StorextsnapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorextsnapInfo> getUniquifier() {
		return null;
	}
}
