package br.com.mind5.business.employeeLeaveDateSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class EmplarchVisiMergeToSelect extends InfoMergerVisitorTemplate<EmplarchInfo, EmplarchInfo> {
	
	@Override public List<EmplarchInfo> beforeMerge(List<EmplarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<EmplarchInfo> getUniquifier() {
		return null;
	}
}
