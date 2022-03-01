package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowordarchMergerVisiToSelect extends InfoMergerVisitorTemplate<SowordarchInfo, SowordarchInfo> {

	@Override public boolean shouldMerge(SowordarchInfo baseInfo, SowordarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowordarchInfo> merge(SowordarchInfo baseInfo, SowordarchInfo selectedInfo) {
		List<SowordarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
