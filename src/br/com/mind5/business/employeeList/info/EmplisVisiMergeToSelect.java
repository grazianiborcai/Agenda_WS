package br.com.mind5.business.employeeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmplisVisiMergeToSelect implements InfoMergerVisitor<EmplisInfo, EmplisInfo> {
	
	@Override public List<EmplisInfo> beforeMerge(List<EmplisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<EmplisInfo> getUniquifier() {
		return null;
	}
}
