package br.com.mind5.business.employeePositionSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmposarchVisiMergeToSelect implements InfoMergerVisitorV3<EmposarchInfo, EmposarchInfo> {
	
	@Override public List<EmposarchInfo> beforeMerge(List<EmposarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<EmposarchInfo> getUniquifier() {
		return null;
	}
}
