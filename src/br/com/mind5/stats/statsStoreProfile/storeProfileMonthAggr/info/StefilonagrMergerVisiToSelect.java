package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StefilonagrMergerVisiToSelect extends InfoMergerVisitorTemplate<StefilonagrInfo, StefilonagrInfo> {

	@Override public boolean shouldMerge(StefilonagrInfo baseInfo, StefilonagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StefilonagrInfo> merge(StefilonagrInfo baseInfo, StefilonagrInfo selectedInfo) {
		List<StefilonagrInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
