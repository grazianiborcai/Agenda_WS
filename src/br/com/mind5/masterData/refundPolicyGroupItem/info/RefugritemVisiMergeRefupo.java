package br.com.mind5.masterData.refundPolicyGroupItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;

final class RefugritemVisiMergeRefupo implements InfoMergerVisitor<RefugritemInfo, RefupoInfo> {
	
	@Override public List<RefugritemInfo> beforeMerge(List<RefugritemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefugritemInfo baseInfo, RefupoInfo selectedInfo) {
		return baseInfo.codRefundPolicy == selectedInfo.codRefundPolicy;
	}
	
	
	
	@Override public List<RefugritemInfo> merge(RefugritemInfo baseInfo, RefupoInfo selectedInfo) {
		List<RefugritemInfo> results = new ArrayList<>();
		
		baseInfo.txtRefundPolicy = selectedInfo.txtRefundPolicy;
		baseInfo.hourBefore = selectedInfo.hourBefore;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefugritemInfo> getUniquifier() {
		return null;
	}
}
