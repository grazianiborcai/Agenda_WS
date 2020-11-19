package br.com.mind5.business.employeeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplisVisiMergeToSelect extends InfoMergerVisitorTemplate<EmplisInfo, EmplisInfo> {
	
	@Override public boolean shouldMerge(EmplisInfo baseInfo, EmplisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmplisInfo> merge(EmplisInfo baseInfo, EmplisInfo selectedInfo) {
		List<EmplisInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
