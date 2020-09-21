package br.com.mind5.business.storeTextDefault.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StorextaultVisiMergeToSelect implements InfoMergerVisitorV3<StorextaultInfo, StorextaultInfo> {
	
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
