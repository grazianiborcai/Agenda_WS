package br.com.mind5.business.ownerSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OwnarchMergerVisiToSelect extends InfoMergerVisitorTemplate<OwnarchInfo, OwnarchInfo> {

	@Override public boolean shouldMerge(OwnarchInfo baseInfo, OwnarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<OwnarchInfo> merge(OwnarchInfo baseInfo, OwnarchInfo selectedInfo) {
		List<OwnarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
