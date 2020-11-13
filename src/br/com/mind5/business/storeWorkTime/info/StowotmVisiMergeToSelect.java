package br.com.mind5.business.storeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StowotmVisiMergeToSelect implements InfoMergerVisitor<StowotmInfo, StowotmInfo> {
	
	@Override public List<StowotmInfo> beforeMerge(List<StowotmInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StowotmInfo baseInfo, StowotmInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StowotmInfo> merge(StowotmInfo baseInfo, StowotmInfo selectedInfo) {
		List<StowotmInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StowotmInfo> getUniquifier() {
		return null;
	}
}
