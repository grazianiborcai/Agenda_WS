package br.com.mind5.business.employeePosition.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmposVisiMergeToSelect extends InfoMergerVisitorTemplate<EmposInfo, EmposInfo> {

	@Override public boolean shouldMerge(EmposInfo baseInfo, EmposInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmposInfo> merge(EmposInfo baseInfo, EmposInfo selectedInfo) {
		List<EmposInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
