package br.com.mind5.payment.storePartnerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

final class StoplisMergerVisiStoparch extends InfoMergerVisitorTemplate<StoplisInfo, StoparchInfo> {

	@Override public boolean shouldMerge(StoplisInfo baseInfo, StoparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoplisInfo> merge(StoplisInfo baseInfo, StoparchInfo selectedInfo) {
		List<StoplisInfo> results = new ArrayList<>();
		
		StoplisInfo result = StoplisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
