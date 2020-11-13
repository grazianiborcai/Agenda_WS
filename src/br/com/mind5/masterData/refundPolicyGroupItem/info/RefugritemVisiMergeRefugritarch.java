package br.com.mind5.masterData.refundPolicyGroupItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;

final class RefugritemVisiMergeRefugritarch implements InfoMergerVisitor<RefugritemInfo, RefugritarchInfo> {
	
	@Override public List<RefugritemInfo> beforeMerge(List<RefugritemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefugritemInfo baseInfo, RefugritarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<RefugritemInfo> merge(RefugritemInfo baseInfo, RefugritarchInfo selectedInfo) {
		List<RefugritemInfo> results = new ArrayList<>();
		
		RefugritemInfo result = RefugritemInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefugritemInfo> getUniquifier() {
		return null;
	}
}
