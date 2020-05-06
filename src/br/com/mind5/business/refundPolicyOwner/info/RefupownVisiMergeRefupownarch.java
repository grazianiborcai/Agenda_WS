package br.com.mind5.business.refundPolicyOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupownarchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class RefupownVisiMergeRefupownarch implements InfoMergerVisitorV3<RefupownInfo, RefupownarchInfo> {
	
	@Override public List<RefupownInfo> beforeMerge(List<RefupownInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefupownInfo baseInfo, RefupownarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<RefupownInfo> merge(RefupownInfo baseInfo, RefupownarchInfo selectedInfo) {
		List<RefupownInfo> results = new ArrayList<>();
		
		RefupownInfo result = RefupownInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefupownInfo> getUniquifier() {
		return null;
	}
}
