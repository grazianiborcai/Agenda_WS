package br.com.mind5.masterData.refundPolicyGroup.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.refundPolicyGroupSearch.info.RefugrarchInfo;

final class RefugroupVisiMergeRefugrarch extends InfoMergerVisitorTemplate<RefugroupInfo, RefugrarchInfo> {

	@Override public boolean shouldMerge(RefugroupInfo baseInfo, RefugrarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<RefugroupInfo> merge(RefugroupInfo baseInfo, RefugrarchInfo selectedInfo) {
		List<RefugroupInfo> results = new ArrayList<>();
		
		RefugroupInfo result = RefugroupInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
