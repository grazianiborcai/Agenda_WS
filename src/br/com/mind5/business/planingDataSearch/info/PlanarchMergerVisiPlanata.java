package br.com.mind5.business.planingDataSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PlanarchMergerVisiPlanata extends InfoMergerVisitorTemplate<PlanarchInfo, PlanataInfo> {

	@Override public boolean shouldMerge(PlanarchInfo baseInfo, PlanataInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.date.equals(selectedInfo.date)   		);
	}
	
	

	@Override public List<PlanarchInfo> merge(PlanarchInfo baseInfo, PlanataInfo selectedInfo) {		
		List<PlanarchInfo> results = new ArrayList<>();
		
		PlanarchInfo result = PlanarchInfo.copyFrom(selectedInfo);
		result.beginTimeSel = baseInfo.beginTimeSel;
		result.endTimeSel = baseInfo.endTimeSel;
		
		results.add(result);
		return results;
	}
}
