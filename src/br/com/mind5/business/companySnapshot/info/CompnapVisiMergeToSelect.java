package br.com.mind5.business.companySnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class CompnapVisiMergeToSelect extends InfoMergerVisitorTemplate<CompnapInfo, CompnapInfo> {
	
	@Override public List<CompnapInfo> beforeMerge(List<CompnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CompnapInfo baseInfo, CompnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CompnapInfo> merge(CompnapInfo baseInfo, CompnapInfo selectedInfo) {
		List<CompnapInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;

		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CompnapInfo> getUniquifier() {
		return null;
	}
}
