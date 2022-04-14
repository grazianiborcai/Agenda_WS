package br.com.mind5.business.storeLunchTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StuntmMergerVisiToDelete extends InfoMergerVisitorTemplate<StuntmInfo, StuntmInfo> {

	@Override public boolean shouldMerge(StuntmInfo baseInfo, StuntmInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StuntmInfo> merge(StuntmInfo baseInfo, StuntmInfo selectedInfo) {
		List<StuntmInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
