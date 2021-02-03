package br.com.mind5.masterData.refundPolicyGroupItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;

final class RefugritemVisiMergeRefugritarch extends InfoMergerVisitorTemplate<RefugritemInfo, RefugritarchInfo> {

	@Override public boolean shouldMerge(RefugritemInfo baseInfo, RefugritarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<RefugritemInfo> merge(RefugritemInfo baseInfo, RefugritarchInfo selectedInfo) {
		List<RefugritemInfo> results = new ArrayList<>();
		
		RefugritemInfo result = RefugritemInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
