package br.com.mind5.business.storeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StolisVisiMergeToSelect implements InfoMergerVisitorV3<StolisInfo, StolisInfo> {
	
	@Override public List<StolisInfo> beforeMerge(List<StolisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StolisInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StolisInfo> merge(StolisInfo baseInfo, StolisInfo selectedInfo) {
		List<StolisInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StolisInfo> getUniquifier() {
		return new StolisUniquifier();
	}
}
