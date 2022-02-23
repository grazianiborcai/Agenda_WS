package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StordagrVisiMergeToSelect extends InfoMergerVisitorTemplate<StordagrInfo, StordagrInfo> {

	@Override public boolean shouldMerge(StordagrInfo baseInfo, StordagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StordagrInfo> merge(StordagrInfo baseInfo, StordagrInfo selectedInfo) {
		List<StordagrInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
