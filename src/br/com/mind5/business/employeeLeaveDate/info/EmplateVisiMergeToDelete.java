package br.com.mind5.business.employeeLeaveDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplateVisiMergeToDelete extends InfoMergerVisitorTemplate<EmplateInfo, EmplateInfo> {

	@Override public boolean shouldMerge(EmplateInfo baseInfo, EmplateInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmplateInfo> merge(EmplateInfo baseInfo, EmplateInfo selectedInfo) {
		List<EmplateInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
