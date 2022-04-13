package br.com.mind5.business.storeLunchTimeSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StuntmarchMergerVisiToSelect extends InfoMergerVisitorTemplate<StuntmarchInfo, StuntmarchInfo> {

	@Override public boolean shouldMerge(StuntmarchInfo baseInfo, StuntmarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StuntmarchInfo> merge(StuntmarchInfo baseInfo, StuntmarchInfo selectedInfo) {
		List<StuntmarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
