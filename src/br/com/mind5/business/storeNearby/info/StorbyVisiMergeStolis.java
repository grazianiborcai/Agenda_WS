package br.com.mind5.business.storeNearby.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StorbyVisiMergeStolis implements InfoMergerVisitorV3<StorbyInfo, StolisInfo> {
	
	@Override public List<StorbyInfo> beforeMerge(List<StorbyInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorbyInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore);
	}
	
	
	
	@Override public List<StorbyInfo> merge(StorbyInfo baseInfo, StolisInfo selectedInfo) {
		List<StorbyInfo> results = new ArrayList<>();
		
		baseInfo.stolisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorbyInfo> getUniquifier() {
		return null;
	}
}
