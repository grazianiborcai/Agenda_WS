package br.com.mind5.business.storeLeaveDateRange.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StolargVisiMergeToSelect extends InfoMergerVisitorTemplate<StolargInfo, StolargInfo> {
	
	@Override public List<StolargInfo> beforeMerge(List<StolargInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StolargInfo baseInfo, StolargInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StolargInfo> merge(StolargInfo baseInfo, StolargInfo selectedInfo) {
		List<StolargInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StolargInfo> getUniquifier() {
		return null;
	}
}
