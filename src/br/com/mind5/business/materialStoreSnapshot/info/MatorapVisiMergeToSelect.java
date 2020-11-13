package br.com.mind5.business.materialStoreSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatorapVisiMergeToSelect implements InfoMergerVisitor<MatorapInfo, MatorapInfo> {
	
	@Override public List<MatorapInfo> beforeMerge(List<MatorapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatorapInfo baseInfo, MatorapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatorapInfo> merge(MatorapInfo baseInfo, MatorapInfo selectedInfo) {
		List<MatorapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatorapInfo> getUniquifier() {
		return null;
	}
}
