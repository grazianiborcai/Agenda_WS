package br.com.mind5.business.personSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PerarchMergerVisiToSelect extends InfoMergerVisitorTemplate<PerarchInfo, PerarchInfo> {

	@Override public boolean shouldMerge(PerarchInfo baseInfo, PerarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	

	@Override public List<PerarchInfo> merge(PerarchInfo baseInfo, PerarchInfo selectedInfo) {
		List<PerarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
