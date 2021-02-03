package br.com.mind5.business.planningTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;

final class PlanimeVisiMergeMoonase extends InfoMergerVisitorTemplate<PlanimeInfo, MoonaseInfo> {
	
	@Override public List<PlanimeInfo> beforeMerge(List<PlanimeInfo> baseInfos) {
		for (PlanimeInfo eachBase : baseInfos) {
			eachBase.moonases = new ArrayList<>();
		}
		
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PlanimeInfo baseInfo, MoonaseInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<PlanimeInfo> merge(PlanimeInfo baseInfo, MoonaseInfo selectedInfo) {
		List<PlanimeInfo> results = new ArrayList<>();
		
		baseInfo.moonases.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<PlanimeInfo> uniquifyHook(List<PlanimeInfo> results) {
		InfoUniquifier<PlanimeInfo> uniquifier = new PlanimeUniquifier();		
		return uniquifier.uniquify(results);
	}
}
