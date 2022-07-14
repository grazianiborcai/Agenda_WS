package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;

final class StoronMergerVisiStoronive extends InfoMergerVisitorTemplate<StoronInfo, StoroniveInfo> {

	@Override public boolean shouldMerge(StoronInfo baseInfo, StoroniveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.calmonth.equals(selectedInfo.calmonth));
	}
	
	
	
	@Override public List<StoronInfo> merge(StoronInfo baseInfo, StoroniveInfo selectedInfo) {
		List<StoronInfo> results = new ArrayList<>();
		
		StoronInfo result = StoronInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
