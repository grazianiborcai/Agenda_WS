package br.com.mind5.business.storeNearby.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StorbyMergerVisiStorite extends InfoMergerVisitorTemplate<StorbyInfo, StoriteInfo> {

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
}
