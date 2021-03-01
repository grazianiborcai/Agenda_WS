package br.com.mind5.stats.statsUserStore.userStoreAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StusoraggVisiMergeToSelect extends InfoMergerVisitorTemplate<StusoraggInfo, StusoraggInfo> {

	@Override public boolean shouldMerge(StusoraggInfo baseInfo, StusoraggInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StusoraggInfo> merge(StusoraggInfo baseInfo, StusoraggInfo selectedInfo) {
		List<StusoraggInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
