package br.com.mind5.business.employeeLunchTimeSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplutmarchMergerVisiToSelect extends InfoMergerVisitorTemplate<EmplutmarchInfo, EmplutmarchInfo> {

	@Override public boolean shouldMerge(EmplutmarchInfo baseInfo, EmplutmarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmplutmarchInfo> merge(EmplutmarchInfo baseInfo, EmplutmarchInfo selectedInfo) {
		List<EmplutmarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
