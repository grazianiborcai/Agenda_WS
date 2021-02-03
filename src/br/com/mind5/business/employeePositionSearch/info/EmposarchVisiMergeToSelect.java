package br.com.mind5.business.employeePositionSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmposarchVisiMergeToSelect extends InfoMergerVisitorTemplate<EmposarchInfo, EmposarchInfo> {

	@Override public boolean shouldMerge(EmposarchInfo baseInfo, EmposarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmposarchInfo> merge(EmposarchInfo baseInfo, EmposarchInfo selectedInfo) {
		List<EmposarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
