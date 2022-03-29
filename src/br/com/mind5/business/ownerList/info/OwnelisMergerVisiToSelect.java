package br.com.mind5.business.ownerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OwnelisMergerVisiToSelect extends InfoMergerVisitorTemplate<OwnelisInfo, OwnelisInfo> {

	@Override public boolean shouldMerge(OwnelisInfo baseInfo, OwnelisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OwnelisInfo> merge(OwnelisInfo baseInfo, OwnelisInfo selectedInfo) {
		List<OwnelisInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
