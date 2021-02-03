package br.com.mind5.business.refundPolicyStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class RefuporeVisiMergeRefupown extends InfoMergerVisitorTemplate<RefuporeInfo, RefupownInfo> {

	@Override public boolean shouldMerge(RefuporeInfo baseInfo, RefupownInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<RefuporeInfo> merge(RefuporeInfo baseInfo, RefupownInfo selectedInfo) {
		List<RefuporeInfo> results = new ArrayList<>();
		
		baseInfo.codRefundPolicyGroup = selectedInfo.codRefundPolicyGroup;
		baseInfo.txtRefundPolicyGroup = selectedInfo.txtRefundPolicyGroup;
		baseInfo.refugritemes = selectedInfo.refugritemes;
		
		results.add(baseInfo);
		return results;
	}
}
