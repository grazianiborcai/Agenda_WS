package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowordiveVisiMergeToSelect extends InfoMergerVisitorTemplate<SowordiveInfo, SowordiveInfo> {

	@Override public boolean shouldMerge(SowordiveInfo baseInfo, SowordiveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowordiveInfo> merge(SowordiveInfo baseInfo, SowordiveInfo selectedInfo) {
		List<SowordiveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
