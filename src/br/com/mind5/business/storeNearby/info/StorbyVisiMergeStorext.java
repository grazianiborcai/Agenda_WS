package br.com.mind5.business.storeNearby.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StorbyVisiMergeStorext extends InfoMergerVisitorTemplate<StorbyInfo, StorextInfo> {

	@Override public boolean shouldMerge(StorbyInfo baseInfo, StorextInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StorbyInfo> merge(StorbyInfo baseInfo, StorextInfo selectedInfo) {
		List<StorbyInfo> results = new ArrayList<>();
		
		baseInfo.storextData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
