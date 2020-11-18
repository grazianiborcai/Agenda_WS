package br.com.mind5.business.refundPolicyOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class RefupownVisiMergeToSelect extends InfoMergerVisitorTemplate<RefupownInfo, RefupownInfo> {
	
	@Override public List<RefupownInfo> beforeMerge(List<RefupownInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefupownInfo baseInfo, RefupownInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<RefupownInfo> merge(RefupownInfo baseInfo, RefupownInfo selectedInfo) {
		List<RefupownInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefupownInfo> getUniquifier() {
		return null;
	}
}
