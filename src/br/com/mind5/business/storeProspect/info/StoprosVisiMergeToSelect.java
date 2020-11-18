package br.com.mind5.business.storeProspect.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StoprosVisiMergeToSelect extends InfoMergerVisitorTemplate<StoprosInfo, StoprosInfo> {
	
	@Override public List<StoprosInfo> beforeMerge(List<StoprosInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoprosInfo baseInfo, StoprosInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoprosInfo> merge(StoprosInfo baseInfo, StoprosInfo selectedInfo) {
		List<StoprosInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoprosInfo> getUniquifier() {
		return null;
	}
}
