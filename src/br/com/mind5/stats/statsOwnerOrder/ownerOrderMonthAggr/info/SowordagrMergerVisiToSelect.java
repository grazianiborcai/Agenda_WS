package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowordagrMergerVisiToSelect extends InfoMergerVisitorTemplate<SowordagrInfo, SowordagrInfo> {

	@Override public boolean shouldMerge(SowordagrInfo baseInfo, SowordagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowordagrInfo> merge(SowordagrInfo baseInfo, SowordagrInfo selectedInfo) {
		List<SowordagrInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
