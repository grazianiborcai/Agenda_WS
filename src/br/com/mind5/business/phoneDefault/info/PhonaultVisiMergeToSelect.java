package br.com.mind5.business.phoneDefault.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class PhonaultVisiMergeToSelect implements InfoMergerVisitorV3<PhonaultInfo, PhonaultInfo> {
	
	@Override public List<PhonaultInfo> beforeMerge(List<PhonaultInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PhonaultInfo baseInfo, PhonaultInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<PhonaultInfo> merge(PhonaultInfo baseInfo, PhonaultInfo selectedInfo) {
		List<PhonaultInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PhonaultInfo> getUniquifier() {
		return null;
	}
}
