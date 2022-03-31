package br.com.mind5.business.storeNearby.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StorbyMergerVisiToSelect extends InfoMergerVisitorTemplate<StorbyInfo, StorbyInfo> {

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
}
