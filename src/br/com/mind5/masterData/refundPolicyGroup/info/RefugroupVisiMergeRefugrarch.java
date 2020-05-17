package br.com.mind5.masterData.refundPolicyGroup.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.refundPolicyGroupSearch.info.RefugrarchInfo;

final class RefugroupVisiMergeRefugrarch implements InfoMergerVisitorV3<RefugroupInfo, RefugrarchInfo> {
	
	@Override public List<RefugroupInfo> beforeMerge(List<RefugroupInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefugroupInfo baseInfo, RefugrarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<RefugroupInfo> merge(RefugroupInfo baseInfo, RefugrarchInfo selectedInfo) {
		List<RefugroupInfo> results = new ArrayList<>();
		
		RefugroupInfo result = RefugroupInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefugroupInfo> getUniquifier() {
		return null;
	}
}
