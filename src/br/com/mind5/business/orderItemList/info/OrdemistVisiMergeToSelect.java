package br.com.mind5.business.orderItemList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrdemistVisiMergeToSelect implements InfoMergerVisitor<OrdemistInfo, OrdemistInfo> {
	
	@Override public List<OrdemistInfo> beforeMerge(List<OrdemistInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdemistInfo baseInfo, OrdemistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OrdemistInfo> merge(OrdemistInfo baseInfo, OrdemistInfo selectedInfo) {
		List<OrdemistInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdemistInfo> getUniquifier() {
		return null;
	}
}
