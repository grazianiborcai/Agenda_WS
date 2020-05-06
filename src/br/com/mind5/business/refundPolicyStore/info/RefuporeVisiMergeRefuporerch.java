package br.com.mind5.business.refundPolicyStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporerchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class RefuporeVisiMergeRefuporerch implements InfoMergerVisitorV3<RefuporeInfo, RefuporerchInfo> {
	
	@Override public List<RefuporeInfo> beforeMerge(List<RefuporeInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefuporeInfo baseInfo, RefuporerchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<RefuporeInfo> merge(RefuporeInfo baseInfo, RefuporerchInfo selectedInfo) {
		List<RefuporeInfo> results = new ArrayList<>();
		
		RefuporeInfo result = RefuporeInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefuporeInfo> getUniquifier() {
		return null;
	}
}
