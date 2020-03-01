package br.com.mind5.payment.storePartnerSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StoparchVisiMergeToSelect implements InfoMergerVisitorV3<StoparchInfo, StoparchInfo> {
	
	@Override public List<StoparchInfo> beforeMerge(List<StoparchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoparchInfo baseInfo, StoparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoparchInfo> merge(StoparchInfo baseInfo, StoparchInfo selectedInfo) {
		List<StoparchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;

		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoparchInfo> getUniquifier() {
		return null;
	}
}
