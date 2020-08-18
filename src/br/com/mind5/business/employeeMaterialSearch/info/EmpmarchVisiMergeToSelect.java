package br.com.mind5.business.employeeMaterialSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmpmarchVisiMergeToSelect implements InfoMergerVisitorV3<EmpmarchInfo, EmpmarchInfo> {
	
	@Override public List<EmpmarchInfo> beforeMerge(List<EmpmarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpmarchInfo baseInfo, EmpmarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpmarchInfo> merge(EmpmarchInfo baseInfo, EmpmarchInfo selectedInfo) {
		List<EmpmarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpmarchInfo> getUniquifier() {
		return null;
	}
}
