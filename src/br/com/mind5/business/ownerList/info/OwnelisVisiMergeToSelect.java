package br.com.mind5.business.ownerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OwnelisVisiMergeToSelect implements InfoMergerVisitor<OwnelisInfo, OwnelisInfo> {
	
	@Override public List<OwnelisInfo> beforeMerge(List<OwnelisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<OwnelisInfo> getUniquifier() {
		return null;
	}
}
