package br.com.mind5.business.refundPolicyStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;

final class RefuporeVisiMergeRefupo implements InfoMergerVisitorV3<RefuporeInfo, RefupoInfo> {
	
	@Override public List<RefuporeInfo> beforeMerge(List<RefuporeInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefuporeInfo baseInfo, RefupoInfo selectedInfo) {
		return baseInfo.codRefundPolicy == selectedInfo.codRefundPolicy;
	}
	
	
	
	@Override public List<RefuporeInfo> merge(RefuporeInfo baseInfo, RefupoInfo selectedInfo) {
		List<RefuporeInfo> results = new ArrayList<>();
		
		baseInfo.txtRefundPolicy = selectedInfo.txtRefundPolicy;
		baseInfo.hourBefore = selectedInfo.hourBefore;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefuporeInfo> getUniquifier() {
		return null;
	}
}
