package br.com.mind5.business.storeFavorite.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoriteVisiMergeStolis extends InfoMergerVisitorTemplate<StoriteInfo, StolisInfo> {

	@Override public boolean shouldMerge(StoriteInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StoriteInfo> merge(StoriteInfo baseInfo, StolisInfo selectedInfo) {
		List<StoriteInfo> results = new ArrayList<>();
		
		baseInfo.stolisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
