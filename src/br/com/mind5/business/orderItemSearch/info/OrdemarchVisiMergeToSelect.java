package br.com.mind5.business.orderItemSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OrdemarchVisiMergeToSelect extends InfoMergerVisitorTemplate<OrdemarchInfo, OrdemarchInfo> {
	
	@Override public List<OrdemarchInfo> beforeMerge(List<OrdemarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdemarchInfo baseInfo, OrdemarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OrdemarchInfo> merge(OrdemarchInfo baseInfo, OrdemarchInfo selectedInfo) {
		List<OrdemarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdemarchInfo> getUniquifier() {
		return null;
	}
}
