package br.com.mind5.business.refundPolicyStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class RefuporeMergerVisiRefuporarch extends InfoMergerVisitorTemplate<RefuporeInfo, RefuporarchInfo> {

	@Override public boolean shouldMerge(RefuporeInfo baseInfo, RefuporarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<RefuporeInfo> merge(RefuporeInfo baseInfo, RefuporarchInfo selectedInfo) {
		List<RefuporeInfo> results = new ArrayList<>();
		
		RefuporeInfo result = RefuporeInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
