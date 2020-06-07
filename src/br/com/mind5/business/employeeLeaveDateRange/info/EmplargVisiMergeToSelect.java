package br.com.mind5.business.employeeLeaveDateRange.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmplargVisiMergeToSelect implements InfoMergerVisitorV3<EmplargInfo, EmplargInfo> {
		
	@Override public List<EmplargInfo> beforeMerge(List<EmplargInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<EmplargInfo> getUniquifier() {
		return null;
	}
}
