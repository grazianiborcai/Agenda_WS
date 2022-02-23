package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StordiveVisiMergeToSelect extends InfoMergerVisitorTemplate<StordiveInfo, StordiveInfo> {

	@Override public boolean shouldMerge(StordiveInfo baseInfo, StordiveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StordiveInfo> merge(StordiveInfo baseInfo, StordiveInfo selectedInfo) {
		List<StordiveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
