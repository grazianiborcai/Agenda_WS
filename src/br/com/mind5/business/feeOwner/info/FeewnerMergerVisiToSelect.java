package br.com.mind5.business.feeOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FeewnerMergerVisiToSelect extends InfoMergerVisitorTemplate<FeewnerInfo, FeewnerInfo> {
	@Override public boolean shouldMerge(FeewnerInfo baseInfo, FeewnerInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<FeewnerInfo> merge(FeewnerInfo baseInfo, FeewnerInfo selectedInfo) {
		List<FeewnerInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
