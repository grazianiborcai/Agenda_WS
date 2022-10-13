package br.com.mind5.business.personLegal.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PeregMergerVisiToSelect extends InfoMergerVisitorTemplate<PeregInfo, PeregInfo> {

	@Override public boolean shouldMerge(PeregInfo baseInfo, PeregInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PeregInfo> merge(PeregInfo baseInfo, PeregInfo selectedInfo) {
		List<PeregInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
}
