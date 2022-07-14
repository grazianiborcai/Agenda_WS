package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;

final class StoronMergerVisiStoronagr extends InfoMergerVisitorTemplate<StoronInfo, StoronagrInfo> {

	@Override public boolean shouldMerge(StoronInfo baseInfo, StoronagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.calmonth.equals(selectedInfo.calmonth));
	}
	
	
	
	@Override public List<StoronInfo> merge(StoronInfo baseInfo, StoronagrInfo selectedInfo) {
		List<StoronInfo> results = new ArrayList<>();
		
		StoronInfo result = StoronInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
