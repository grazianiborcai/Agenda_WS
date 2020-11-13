package br.com.mind5.business.storeProspectSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoprarchVisiMergeToSelect implements InfoMergerVisitor<StoprarchInfo, StoprarchInfo> {
	
	@Override public List<StoprarchInfo> beforeMerge(List<StoprarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoprarchInfo baseInfo, StoprarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoprarchInfo> merge(StoprarchInfo baseInfo, StoprarchInfo selectedInfo) {
		List<StoprarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoprarchInfo> getUniquifier() {
		return null;
	}
}
