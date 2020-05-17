package br.com.mind5.business.refundPolicyOwnerSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class RefupowarchVisiMergeToSelect implements InfoMergerVisitorV3<RefupowarchInfo, RefupowarchInfo> {
	
	@Override public List<RefupowarchInfo> beforeMerge(List<RefupowarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefupowarchInfo baseInfo, RefupowarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<RefupowarchInfo> merge(RefupowarchInfo baseInfo, RefupowarchInfo selectedInfo) {
		List<RefupowarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefupowarchInfo> getUniquifier() {
		return null;
	}
}
