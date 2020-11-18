package br.com.mind5.business.refundPolicyStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class RefuporeVisiMergeToSelect extends InfoMergerVisitorTemplate<RefuporeInfo, RefuporeInfo> {
	
	@Override public List<RefuporeInfo> beforeMerge(List<RefuporeInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefuporeInfo baseInfo, RefuporeInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<RefuporeInfo> merge(RefuporeInfo baseInfo, RefuporeInfo selectedInfo) {
		List<RefuporeInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefuporeInfo> getUniquifier() {
		return null;
	}
}
