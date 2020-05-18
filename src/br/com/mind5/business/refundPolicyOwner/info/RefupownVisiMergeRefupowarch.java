package br.com.mind5.business.refundPolicyOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupowarchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class RefupownVisiMergeRefupowarch implements InfoMergerVisitorV3<RefupownInfo, RefupowarchInfo> {
	
	@Override public List<RefupownInfo> beforeMerge(List<RefupownInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefupownInfo baseInfo, RefupowarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<RefupownInfo> merge(RefupownInfo baseInfo, RefupowarchInfo selectedInfo) {
		List<RefupownInfo> results = new ArrayList<>();
		
		RefupownInfo result = RefupownInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefupownInfo> getUniquifier() {
		return null;
	}
}
