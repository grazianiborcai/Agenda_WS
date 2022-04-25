package br.com.mind5.business.employeeLunchTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplutmMergerVisiToDelete extends InfoMergerVisitorTemplate<EmplutmInfo, EmplutmInfo> {
	
	@Override public boolean shouldMerge(EmplutmInfo baseInfo, EmplutmInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmplutmInfo> merge(EmplutmInfo baseInfo, EmplutmInfo selectedInfo) {
		List<EmplutmInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
