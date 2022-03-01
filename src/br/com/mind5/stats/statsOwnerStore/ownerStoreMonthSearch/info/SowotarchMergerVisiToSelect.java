package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowotarchMergerVisiToSelect extends InfoMergerVisitorTemplate<SowotarchInfo, SowotarchInfo> {

	@Override public boolean shouldMerge(SowotarchInfo baseInfo, SowotarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowotarchInfo> merge(SowotarchInfo baseInfo, SowotarchInfo selectedInfo) {
		List<SowotarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
