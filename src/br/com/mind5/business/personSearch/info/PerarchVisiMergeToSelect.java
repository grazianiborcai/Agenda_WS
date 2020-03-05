package br.com.mind5.business.personSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class PerarchVisiMergeToSelect implements InfoMergerVisitorV3<PerarchInfo, PerarchInfo> {
	
	@Override public List<PerarchInfo> beforeMerge(List<PerarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PerarchInfo baseInfo, PerarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	

	@Override public List<PerarchInfo> merge(PerarchInfo baseInfo, PerarchInfo selectedInfo) {
		List<PerarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PerarchInfo> getUniquifier() {
		return null;
	}
}
