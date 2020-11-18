package br.com.mind5.business.storeNearby.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorbyVisiMergeToSelect extends InfoMergerVisitorTemplate<StorbyInfo, StorbyInfo> {
	
	@Override public List<StorbyInfo> beforeMerge(List<StorbyInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorbyInfo baseInfo, StorbyInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StorbyInfo> merge(StorbyInfo baseInfo, StorbyInfo selectedInfo) {
		List<StorbyInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.latitude = baseInfo.latitude;
		selectedInfo.longitude = baseInfo.longitude;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorbyInfo> getUniquifier() {
		return null;
	}
}
