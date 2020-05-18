package br.com.mind5.business.refundPolicyStoreSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class RefuporarchVisiMergeToSelect implements InfoMergerVisitorV3<RefuporarchInfo, RefuporarchInfo> {
	
	@Override public List<RefuporarchInfo> beforeMerge(List<RefuporarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<RefuporarchInfo> getUniquifier() {
		return null;
	}
}
