package br.com.mind5.payment.storePartnerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoplisMergerVisiToSelect extends InfoMergerVisitorTemplate<StoplisInfo, StoplisInfo> {

	@Override public boolean shouldMerge(StoplisInfo baseInfo, StoplisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoplisInfo> merge(StoplisInfo baseInfo, StoplisInfo selectedInfo) {
		List<StoplisInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;

		results.add(selectedInfo);
		return results;
	}
}
