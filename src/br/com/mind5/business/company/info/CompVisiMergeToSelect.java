package br.com.mind5.business.company.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class CompVisiMergeToSelect extends InfoMergerVisitorTemplate<CompInfo, CompInfo> {
	
	@Override public List<CompInfo> beforeMerge(List<CompInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CompInfo baseInfo, CompInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CompInfo> merge(CompInfo baseInfo, CompInfo selectedInfo) {
		List<CompInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;

		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CompInfo> getUniquifier() {
		return null;
	}
}
