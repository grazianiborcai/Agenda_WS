package br.com.mind5.business.employeeLunchTimeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplutmapMergerVisiToSelect extends InfoMergerVisitorTemplate<EmplutmapInfo, EmplutmapInfo> {
	
	@Override public boolean shouldMerge(EmplutmapInfo baseInfo, EmplutmapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmplutmapInfo> merge(EmplutmapInfo baseInfo, EmplutmapInfo selectedInfo) {
		List<EmplutmapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
