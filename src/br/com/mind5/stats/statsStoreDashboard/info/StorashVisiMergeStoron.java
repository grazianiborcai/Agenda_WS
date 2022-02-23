package br.com.mind5.stats.statsStoreDashboard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;

final class StorashVisiMergeStoron extends InfoMergerVisitorTemplate<StorashInfo, StoronInfo> {

	@Override public boolean shouldMerge(StorashInfo baseInfo, StoronInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore);
	}
	
	
	
	@Override public List<StorashInfo> merge(StorashInfo baseInfo, StoronInfo selectedInfo) {
		List<StorashInfo> results = new ArrayList<>();
		
		baseInfo.storones.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
