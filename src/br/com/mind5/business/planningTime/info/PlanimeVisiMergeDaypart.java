package br.com.mind5.business.planningTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;

final class PlanimeVisiMergeDaypart extends InfoMergerVisitorTemplate<PlanimeInfo, DaypartInfo> {
	
	@Override public List<PlanimeInfo> beforeMerge(List<PlanimeInfo> baseInfos) {
		for (PlanimeInfo eachBase : baseInfos) {
			eachBase.dayparts = new ArrayList<>();
		}
		
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PlanimeInfo baseInfo, DaypartInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<PlanimeInfo> merge(PlanimeInfo baseInfo, DaypartInfo selectedInfo) {
		List<PlanimeInfo> results = new ArrayList<>();
		
		baseInfo.dayparts.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PlanimeInfo> getUniquifier() {
		return new PlanimeUniquifier();
	}
}
