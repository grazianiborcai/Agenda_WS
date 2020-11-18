package br.com.mind5.business.planningTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class PlanimeVisiMergeMatlis extends InfoMergerVisitorTemplate<PlanimeInfo, MatlisInfo> {
	
	@Override public List<PlanimeInfo> beforeMerge(List<PlanimeInfo> baseInfos) {
		for (PlanimeInfo eachBase : baseInfos) {
			eachBase.matlises = new ArrayList<>();
		}
		
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PlanimeInfo baseInfo, MatlisInfo selectedInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner);
	}
	
	
	
	@Override public List<PlanimeInfo> merge(PlanimeInfo baseInfo, MatlisInfo selectedInfo) {
		List<PlanimeInfo> results = new ArrayList<>();
		
		baseInfo.matlises.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PlanimeInfo> getUniquifier() {
		return new PlanimeUniquifier();
	}
}
