package br.com.mind5.business.storeManager.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StomanMergerVisiToSelect extends InfoMergerVisitorTemplate<StomanInfo, StomanInfo> {

	@Override public boolean shouldMerge(StomanInfo baseInfo, StomanInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StomanInfo> merge(StomanInfo baseInfo, StomanInfo selectedInfo) {
		List<StomanInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
