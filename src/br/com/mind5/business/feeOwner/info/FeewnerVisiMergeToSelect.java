package br.com.mind5.business.feeOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class FeewnerVisiMergeToSelect extends InfoMergerVisitorTemplate<FeewnerInfo, FeewnerInfo> {
	
	@Override public List<FeewnerInfo> beforeMerge(List<FeewnerInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<FeewnerInfo> getUniquifier() {
		return null;
	}
}
