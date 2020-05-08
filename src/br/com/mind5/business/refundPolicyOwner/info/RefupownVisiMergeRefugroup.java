package br.com.mind5.business.refundPolicyOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;

final class RefupownVisiMergeRefugroup implements InfoMergerVisitorV3<RefupownInfo, RefugroupInfo> {
	
	@Override public List<RefupownInfo> beforeMerge(List<RefupownInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefupownInfo baseInfo, RefugroupInfo selectedInfo) {
		if (baseInfo.codRefundPolicyGroup <= 0)
			return true;
		
		return baseInfo.codRefundPolicyGroup == selectedInfo.codRefundPolicyGroup;
	}
	
	
	
	@Override public List<RefupownInfo> merge(RefupownInfo baseInfo, RefugroupInfo selectedInfo) {
		List<RefupownInfo> results = new ArrayList<>();
		
		baseInfo.codRefundPolicyGroup = selectedInfo.codRefundPolicyGroup;
		baseInfo.txtRefundPolicyGroup = selectedInfo.txtRefundPolicyGroup;
		baseInfo.refugritemes = selectedInfo.refugritemes;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefupownInfo> getUniquifier() {
		return null;
	}
}
