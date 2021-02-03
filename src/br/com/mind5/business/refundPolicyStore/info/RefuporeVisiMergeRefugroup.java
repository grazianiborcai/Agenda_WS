package br.com.mind5.business.refundPolicyStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;

final class RefuporeVisiMergeRefugroup extends InfoMergerVisitorTemplate<RefuporeInfo, RefugroupInfo> {

	@Override public boolean shouldMerge(RefuporeInfo baseInfo, RefugroupInfo selectedInfo) {
		return baseInfo.codRefundPolicyGroup == selectedInfo.codRefundPolicyGroup;
	}
	
	
	
	@Override public List<RefuporeInfo> merge(RefuporeInfo baseInfo, RefugroupInfo selectedInfo) {
		List<RefuporeInfo> results = new ArrayList<>();
		
		baseInfo.txtRefundPolicyGroup = selectedInfo.txtRefundPolicyGroup;
		baseInfo.refugritemes = selectedInfo.refugritemes;
		
		results.add(baseInfo);
		return results;
	}
}
