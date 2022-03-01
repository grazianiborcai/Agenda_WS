package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowotagrMergerVisiToSelect extends InfoMergerVisitorTemplate<SowotagrInfo, SowotagrInfo> {

	@Override public boolean shouldMerge(SowotagrInfo baseInfo, SowotagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowotagrInfo> merge(SowotagrInfo baseInfo, SowotagrInfo selectedInfo) {
		List<SowotagrInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
