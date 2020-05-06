package br.com.mind5.business.refundPolicyOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;

final class RefupownVisiMergeRefupo implements InfoMergerVisitorV3<RefupownInfo, RefupoInfo> {
	
	@Override public List<RefupownInfo> beforeMerge(List<RefupownInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefupownInfo baseInfo, RefupoInfo selectedInfo) {
		return baseInfo.codRefundPolicy == selectedInfo.codRefundPolicy;
	}
	
	
	
	@Override public List<RefupownInfo> merge(RefupownInfo baseInfo, RefupoInfo selectedInfo) {
		List<RefupownInfo> results = new ArrayList<>();
		
		baseInfo.txtRefundPolicy = selectedInfo.txtRefundPolicy;
		baseInfo.hourBefore = selectedInfo.hourBefore;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefupownInfo> getUniquifier() {
		return null;
	}
}
