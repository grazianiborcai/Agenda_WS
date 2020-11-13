package br.com.mind5.business.storeWorkTimeSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StowotarchVisiMergeToSelect implements InfoMergerVisitor<StowotarchInfo, StowotarchInfo> {
	
	@Override public List<StowotarchInfo> beforeMerge(List<StowotarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StowotarchInfo baseInfo, StowotarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StowotarchInfo> merge(StowotarchInfo baseInfo, StowotarchInfo selectedInfo) {
		List<StowotarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StowotarchInfo> getUniquifier() {
		return null;
	}
}
