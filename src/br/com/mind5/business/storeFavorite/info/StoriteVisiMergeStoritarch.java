package br.com.mind5.business.storeFavorite.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoriteVisiMergeStoritarch extends InfoMergerVisitorTemplate<StoriteInfo, StoritarchInfo> {

	@Override public boolean shouldMerge(StoriteInfo baseInfo, StoritarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoriteInfo> merge(StoriteInfo baseInfo, StoritarchInfo selectedInfo) {
		List<StoriteInfo> results = new ArrayList<>();
		
		StoriteInfo result = StoriteInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
