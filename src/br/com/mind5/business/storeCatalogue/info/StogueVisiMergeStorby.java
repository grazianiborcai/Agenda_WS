package br.com.mind5.business.storeCatalogue.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StogueVisiMergeStorby extends InfoMergerVisitorTemplate<StogueInfo, StorbyInfo> {

	@Override public boolean shouldMerge(StogueInfo baseInfo, StorbyInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StogueInfo> merge(StogueInfo baseInfo, StorbyInfo selectedInfo) {
		List<StogueInfo> results = new ArrayList<>();
		
		baseInfo.storbys.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
