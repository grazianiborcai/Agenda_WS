package br.com.mind5.business.storeWorkTimeRange.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoworgMergerVisiToSelect extends InfoMergerVisitorTemplate<StoworgInfo, StoworgInfo> {

	@Override public boolean shouldMerge(StoworgInfo baseInfo, StoworgInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoworgInfo> merge(StoworgInfo baseInfo, StoworgInfo selectedInfo) {
		List<StoworgInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
