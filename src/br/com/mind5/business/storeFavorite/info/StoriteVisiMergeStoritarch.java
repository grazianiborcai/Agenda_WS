package br.com.mind5.business.storeFavorite.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoriteVisiMergeStoritarch implements InfoMergerVisitor<StoriteInfo, StoritarchInfo> {
	
	@Override public List<StoriteInfo> beforeMerge(List<StoriteInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoriteInfo baseInfo, StoritarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoriteInfo> merge(StoriteInfo baseInfo, StoritarchInfo selectedInfo) {
		List<StoriteInfo> results = new ArrayList<>();
		
		StoriteInfo result = StoriteInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoriteInfo> getUniquifier() {
		return null;
	}
}
