package br.com.mind5.masterData.refundPolicyGroup.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.refundPolicyGroupHeader.info.RefugraderInfo;

final class RefugroupVisiMergeRefugrader implements InfoMergerVisitorV3<RefugroupInfo, RefugraderInfo> {
	
	@Override public List<RefugroupInfo> beforeMerge(List<RefugroupInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefugroupInfo baseInfo, RefugraderInfo selectedInfo) {
		return baseInfo.codRefundPolicyGroup == selectedInfo.codRefundPolicyGroup;
	}
	
	
	
	@Override public List<RefugroupInfo> merge(RefugroupInfo baseInfo, RefugraderInfo selectedInfo) {
		List<RefugroupInfo> results = new ArrayList<>();
		
		baseInfo.txtRefundPolicyGroup = selectedInfo.txtRefundPolicyGroup;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefugroupInfo> getUniquifier() {
		return null;
	}
}
