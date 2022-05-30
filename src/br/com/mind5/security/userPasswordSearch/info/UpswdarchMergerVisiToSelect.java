package br.com.mind5.security.userPasswordSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class UpswdarchMergerVisiToSelect extends InfoMergerVisitorTemplate<UpswdarchInfo, UpswdarchInfo> {

	@Override public boolean shouldMerge(UpswdarchInfo baseInfo, UpswdarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}	
	
	

	@Override public List<UpswdarchInfo> merge(UpswdarchInfo baseInfo, UpswdarchInfo selectedInfo) {
		List<UpswdarchInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
