package br.com.mind5.payment.storePartnerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StoplisVisiMergeToSelect extends InfoMergerVisitorTemplate<StoplisInfo, StoplisInfo> {
	
	@Override public List<StoplisInfo> beforeMerge(List<StoplisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<StoplisInfo> getUniquifier() {
		return null;
	}
}
