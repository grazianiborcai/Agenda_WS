package br.com.mind5.business.storeNearby.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StorbyVisiMergeStorite implements InfoMergerVisitor<StorbyInfo, StoriteInfo> {
	
	@Override public List<StorbyInfo> beforeMerge(List<StorbyInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorbyInfo baseInfo, StoriteInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StorbyInfo> merge(StorbyInfo baseInfo, StoriteInfo selectedInfo) {
		List<StorbyInfo> results = new ArrayList<>();
		
		baseInfo.isFavorite = true;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorbyInfo> getUniquifier() {
		return null;
	}
}
