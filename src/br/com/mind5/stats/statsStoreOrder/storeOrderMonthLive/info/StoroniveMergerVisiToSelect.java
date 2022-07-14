package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoroniveMergerVisiToSelect extends InfoMergerVisitorTemplate<StoroniveInfo, StoroniveInfo> {

	@Override public boolean shouldMerge(StoroniveInfo baseInfo, StoroniveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoroniveInfo> merge(StoroniveInfo baseInfo, StoroniveInfo selectedInfo) {
		List<StoroniveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
