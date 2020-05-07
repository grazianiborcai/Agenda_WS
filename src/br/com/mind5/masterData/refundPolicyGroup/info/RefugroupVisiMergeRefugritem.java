package br.com.mind5.masterData.refundPolicyGroup.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;

final class RefugroupVisiMergeRefugritem implements InfoMergerVisitorV3<RefugroupInfo, RefugritemInfo> {
	
	@Override public List<RefugroupInfo> beforeMerge(List<RefugroupInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefugroupInfo baseInfo, RefugritemInfo selectedInfo) {
		return baseInfo.codRefundPolicyGroup == selectedInfo.codRefundPolicyGroup;
	}
	
	
	
	@Override public List<RefugroupInfo> merge(RefugroupInfo baseInfo, RefugritemInfo selectedInfo) {
		List<RefugroupInfo> results = new ArrayList<>();
		
		baseInfo.refugritemes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefugroupInfo> getUniquifier() {
		return null;
	}
}
