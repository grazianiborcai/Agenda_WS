package br.com.mind5.payment.storePartnerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

final class StoplisVisiMergeStoparch extends InfoMergerVisitorTemplate<StoplisInfo, StoparchInfo> {
	
	@Override public List<StoplisInfo> beforeMerge(List<StoplisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoplisInfo baseInfo, StoparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoplisInfo> merge(StoplisInfo baseInfo, StoparchInfo selectedInfo) {
		List<StoplisInfo> results = new ArrayList<>();
		
		StoplisInfo result = StoplisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoplisInfo> getUniquifier() {
		return null;
	}
}
