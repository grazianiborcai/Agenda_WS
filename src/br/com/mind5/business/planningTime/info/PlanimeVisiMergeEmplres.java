package br.com.mind5.business.planningTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class PlanimeVisiMergeEmplres extends InfoMergerVisitorTemplate<PlanimeInfo, EmplresInfo> {
	
	@Override public List<PlanimeInfo> beforeMerge(List<PlanimeInfo> baseInfos) {
		for (PlanimeInfo eachBase : baseInfos) {
			eachBase.emplreses = new ArrayList<>();
		}
		
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PlanimeInfo baseInfo, EmplresInfo selectedInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner);
	}
	
	
	
	@Override public List<PlanimeInfo> merge(PlanimeInfo baseInfo, EmplresInfo selectedInfo) {
		List<PlanimeInfo> results = new ArrayList<>();
		
		baseInfo.emplreses.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<PlanimeInfo> uniquifyHook(List<PlanimeInfo> results) {
		InfoUniquifier<PlanimeInfo> uniquifier = new PlanimeUniquifier();		
		return uniquifier.uniquify(results);
	}
}
