package br.com.mind5.stats.statsStoreDashboard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;

final class StorashMergerVisiStord extends InfoMergerVisitorTemplate<StorashInfo, StordInfo> {

	@Override public boolean shouldMerge(StorashInfo baseInfo, StordInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.calmonth.equals(selectedInfo.calmonth));
	}
	
	
	
	@Override public List<StorashInfo> merge(StorashInfo baseInfo, StordInfo selectedInfo) {
		List<StorashInfo> results = new ArrayList<>();
		
		baseInfo.stordes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
