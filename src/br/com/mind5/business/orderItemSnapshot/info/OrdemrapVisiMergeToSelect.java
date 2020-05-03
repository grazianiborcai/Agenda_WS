package br.com.mind5.business.orderItemSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OrdemrapVisiMergeToSelect implements InfoMergerVisitorV3<OrdemrapInfo, OrdemrapInfo> {
	
	@Override public List<OrdemrapInfo> beforeMerge(List<OrdemrapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdemrapInfo baseInfo, OrdemrapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OrdemrapInfo> merge(OrdemrapInfo baseInfo, OrdemrapInfo selectedInfo) {
		List<OrdemrapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdemrapInfo> getUniquifier() {
		return null;
	}
}
