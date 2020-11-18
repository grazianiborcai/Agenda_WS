package br.com.mind5.business.planingData.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class PlanataVisiMergeToSelect extends InfoMergerVisitorTemplate<PlanataInfo, PlanataInfo> {
	
	@Override public List<PlanataInfo> beforeMerge(List<PlanataInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PlanataInfo baseInfo, PlanataInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<PlanataInfo> merge(PlanataInfo baseInfo, PlanataInfo selectedInfo) {
		List<PlanataInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PlanataInfo> getUniquifier() {
		return null;
	}
}
