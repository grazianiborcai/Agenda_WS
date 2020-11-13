package br.com.mind5.business.storeFavorite.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoriteVisiMergeToSelect implements InfoMergerVisitor<StoriteInfo, StoriteInfo> {
	
	@Override public List<StoriteInfo> beforeMerge(List<StoriteInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoriteInfo baseInfo, StoriteInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoriteInfo> merge(StoriteInfo baseInfo, StoriteInfo selectedInfo) {
		List<StoriteInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoriteInfo> getUniquifier() {
		return null;
	}
}
