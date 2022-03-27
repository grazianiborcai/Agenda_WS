package br.com.mind5.business.storeWorkTimeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StowotmapMergerVisiToSelect extends InfoMergerVisitorTemplate<StowotmapInfo, StowotmapInfo> {

	@Override public boolean shouldMerge(StowotmapInfo baseInfo, StowotmapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StowotmapInfo> merge(StowotmapInfo baseInfo, StowotmapInfo selectedInfo) {
		List<StowotmapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
