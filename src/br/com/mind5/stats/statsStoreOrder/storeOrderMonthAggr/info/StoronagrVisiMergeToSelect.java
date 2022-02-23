package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoronagrVisiMergeToSelect extends InfoMergerVisitorTemplate<StoronagrInfo, StoronagrInfo> {

	@Override public boolean shouldMerge(StoronagrInfo baseInfo, StoronagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoronagrInfo> merge(StoronagrInfo baseInfo, StoronagrInfo selectedInfo) {
		List<StoronagrInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
