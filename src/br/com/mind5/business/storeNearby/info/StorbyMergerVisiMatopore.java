package br.com.mind5.business.storeNearby.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StorbyMergerVisiMatopore extends InfoMergerVisitorTemplate<StorbyInfo, MatoporeInfo> {

	@Override public boolean shouldMerge(StorbyInfo baseInfo, MatoporeInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StorbyInfo> merge(StorbyInfo baseInfo, MatoporeInfo selectedInfo) {
		List<StorbyInfo> results = new ArrayList<>();
		
		baseInfo.matopores.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
