package br.com.mind5.business.employeeLeaveDateRange.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplargVisiMergeToSelect extends InfoMergerVisitorTemplate<EmplargInfo, EmplargInfo> {

	@Override public boolean shouldMerge(EmplargInfo baseInfo, EmplargInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmplargInfo> merge(EmplargInfo baseInfo, EmplargInfo selectedInfo) {
		List<EmplargInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
