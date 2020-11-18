package br.com.mind5.business.phoneSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class PhonarchVisiMergeToSelect extends InfoMergerVisitorTemplate<PhonarchInfo, PhonarchInfo> {
	
	@Override public List<PhonarchInfo> beforeMerge(List<PhonarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PhonarchInfo baseInfo, PhonarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<PhonarchInfo> merge(PhonarchInfo baseInfo, PhonarchInfo selectedInfo) {
		List<PhonarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PhonarchInfo> getUniquifier() {
		return null;
	}
}
