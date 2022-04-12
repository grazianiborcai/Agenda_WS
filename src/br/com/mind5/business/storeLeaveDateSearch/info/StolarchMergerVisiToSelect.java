package br.com.mind5.business.storeLeaveDateSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StolarchMergerVisiToSelect extends InfoMergerVisitorTemplate<StolarchInfo, StolarchInfo> {

	@Override public boolean shouldMerge(StolarchInfo baseInfo, StolarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StolarchInfo> merge(StolarchInfo baseInfo, StolarchInfo selectedInfo) {
		List<StolarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
