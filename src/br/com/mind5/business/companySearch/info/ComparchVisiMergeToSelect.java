package br.com.mind5.business.companySearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class ComparchVisiMergeToSelect extends InfoMergerVisitorTemplate<ComparchInfo, ComparchInfo> {

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
}
