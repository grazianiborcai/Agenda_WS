package br.com.mind5.business.storeSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class SotarchVisiMergeToSelect implements InfoMergerVisitorV3<SotarchInfo, SotarchInfo> {

	@Override public List<SotarchInfo> beforeMerge(List<SotarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SotarchInfo baseInfo, SotarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SotarchInfo> merge(SotarchInfo baseInfo, SotarchInfo selectedInfo) {
		List<SotarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SotarchInfo> getUniquifier() {
		return null;
	}
}
