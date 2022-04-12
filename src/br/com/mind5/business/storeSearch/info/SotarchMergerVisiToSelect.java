package br.com.mind5.business.storeSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SotarchMergerVisiToSelect extends InfoMergerVisitorTemplate<SotarchInfo, SotarchInfo> {

	@Override public boolean shouldMerge(SotarchInfo baseInfo, SotarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SotarchInfo> merge(SotarchInfo baseInfo, SotarchInfo selectedInfo) {
		List<SotarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
