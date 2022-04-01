package br.com.mind5.business.companySnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CompnapMergerVisiToSelect extends InfoMergerVisitorTemplate<CompnapInfo, CompnapInfo> {

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
}
