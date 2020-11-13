package br.com.mind5.business.companySearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class ComparchVisiMergeToSelect implements InfoMergerVisitor<ComparchInfo, ComparchInfo> {

	@Override public List<ComparchInfo> beforeMerge(List<ComparchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(ComparchInfo baseInfo, ComparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<ComparchInfo> merge(ComparchInfo baseInfo, ComparchInfo selectedInfo) {
		List<ComparchInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;

		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<ComparchInfo> getUniquifier() {
		return null;
	}
}
