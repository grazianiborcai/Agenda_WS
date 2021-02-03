package br.com.mind5.payment.storePartnerSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoparchVisiMergeToSelect extends InfoMergerVisitorTemplate<StoparchInfo, StoparchInfo> {

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
}
