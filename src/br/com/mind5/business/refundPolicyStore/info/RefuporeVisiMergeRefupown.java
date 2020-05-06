package br.com.mind5.business.refundPolicyStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class RefuporeVisiMergeRefupown implements InfoMergerVisitorV3<RefuporeInfo, RefupownInfo> {
	
	@Override public List<RefuporeInfo> beforeMerge(List<RefuporeInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefuporeInfo baseInfo, RefupownInfo selectedInfo) {
		return baseInfo.codOwner == selectedInfo.codOwner;
	}
	
	
	
	@Override public List<RefuporeInfo> merge(RefuporeInfo baseInfo, RefupownInfo selectedInfo) {
		List<RefuporeInfo> results = new ArrayList<>();
		
		baseInfo.codRefundPolicy = selectedInfo.codRefundPolicy;
		baseInfo.txtRefundPolicy = selectedInfo.txtRefundPolicy;
		baseInfo.hourBefore = selectedInfo.hourBefore;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefuporeInfo> getUniquifier() {
		return null;
	}
}
