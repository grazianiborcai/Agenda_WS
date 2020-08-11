package br.com.mind5.security.userPasswordSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class UpswdarchVisiMergeToSelect implements InfoMergerVisitorV3<UpswdarchInfo, UpswdarchInfo> {
	
	@Override public List<UpswdarchInfo> beforeMerge(List<UpswdarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(UpswdarchInfo baseInfo, UpswdarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}	
	
	

	@Override public List<UpswdarchInfo> merge(UpswdarchInfo baseInfo, UpswdarchInfo selectedInfo) {
		List<UpswdarchInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UpswdarchInfo> getUniquifier() {
		return null;
	}
}
