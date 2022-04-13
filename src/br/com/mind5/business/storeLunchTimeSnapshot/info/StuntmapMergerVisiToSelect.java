package br.com.mind5.business.storeLunchTimeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StuntmapMergerVisiToSelect extends InfoMergerVisitorTemplate<StuntmapInfo, StuntmapInfo> {

	@Override public boolean shouldMerge(StuntmapInfo baseInfo, StuntmapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StuntmapInfo> merge(StuntmapInfo baseInfo, StuntmapInfo selectedInfo) {
		List<StuntmapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
