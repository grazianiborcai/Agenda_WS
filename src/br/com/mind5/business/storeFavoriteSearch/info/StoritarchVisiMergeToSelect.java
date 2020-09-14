package br.com.mind5.business.storeFavoriteSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StoritarchVisiMergeToSelect implements InfoMergerVisitorV3<StoritarchInfo, StoritarchInfo> {
	
	@Override public List<StoritarchInfo> beforeMerge(List<StoritarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoritarchInfo baseInfo, StoritarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoritarchInfo> merge(StoritarchInfo baseInfo, StoritarchInfo selectedInfo) {
		List<StoritarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoritarchInfo> getUniquifier() {
		return null;
	}
}
