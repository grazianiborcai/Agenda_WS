package br.com.mind5.business.employeeLeaveDateSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplarchMergerVisiToSelect extends InfoMergerVisitorTemplate<EmplarchInfo, EmplarchInfo> {

	@Override public boolean shouldMerge(EmplarchInfo baseInfo, EmplarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmplarchInfo> merge(EmplarchInfo baseInfo, EmplarchInfo selectedInfo) {
		List<EmplarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
