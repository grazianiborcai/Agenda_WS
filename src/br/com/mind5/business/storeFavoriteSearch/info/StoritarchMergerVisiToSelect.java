package br.com.mind5.business.storeFavoriteSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoritarchMergerVisiToSelect extends InfoMergerVisitorTemplate<StoritarchInfo, StoritarchInfo> {

	@Override public boolean shouldMerge(StoritarchInfo baseInfo, StoritarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoritarchInfo> merge(StoritarchInfo baseInfo, StoritarchInfo selectedInfo) {
		List<StoritarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
