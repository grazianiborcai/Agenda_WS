package br.com.mind5.business.refundPolicyStoreSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class RefuporarchVisiMergeToSelect extends InfoMergerVisitorTemplate<RefuporarchInfo, RefuporarchInfo> {

	@Override public boolean shouldMerge(RefuporarchInfo baseInfo, RefuporarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<RefuporarchInfo> merge(RefuporarchInfo baseInfo, RefuporarchInfo selectedInfo) {
		List<RefuporarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
