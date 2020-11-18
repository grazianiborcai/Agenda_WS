package br.com.mind5.business.storeTextDefault.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorextaultVisiMergeToSelect extends InfoMergerVisitorTemplate<StorextaultInfo, StorextaultInfo> {
	
	@Override public List<StorextaultInfo> beforeMerge(List<StorextaultInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorextaultInfo baseInfo, StorextaultInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StorextaultInfo> merge(StorextaultInfo baseInfo, StorextaultInfo selectedInfo) {
		List<StorextaultInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorextaultInfo> getUniquifier() {
		return null;
	}
}
