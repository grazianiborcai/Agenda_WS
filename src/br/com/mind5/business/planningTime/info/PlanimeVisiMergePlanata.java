package br.com.mind5.business.planningTime.info;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class PlanimeVisiMergePlanata extends InfoMergerVisitorTemplate<PlanimeInfo, PlanataInfo> {
	
	@Override public List<PlanimeInfo> beforeMerge(List<PlanimeInfo> baseInfos) {
		for (PlanimeInfo eachBase : baseInfos) {
			eachBase.planatas = new ArrayList<>();
			eachBase.dates = new ArrayList<>();
		}
		
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PlanimeInfo baseInfo, PlanataInfo selectedInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner);
	}
	
	
	
	@Override public List<PlanimeInfo> merge(PlanimeInfo baseInfo, PlanataInfo selectedInfo) {
		List<PlanimeInfo> results = new ArrayList<>();
		
		baseInfo.planatas.add(selectedInfo);
		baseInfo.dates.add(selectedInfo.date);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected List<PlanimeInfo> afterMergeHook(List<PlanimeInfo> results)  {
		for (PlanimeInfo eachResult : results) {
			eachResult.planatas = super.sortAscending(eachResult.planatas);
		}
		
		return results;
	}
	
	
	
	@Override public List<PlanimeInfo> uniquifyHook(List<PlanimeInfo> results) {
		InfoUniquifier<PlanimeInfo> uniquifier = new PlanimeUniquifier();		
		return uniquifier.uniquify(results);
	}
}
