package br.com.mind5.business.planingDataSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class PlanarchVisiMergePlanata implements InfoMergerVisitorV3<PlanarchInfo, PlanataInfo> {
	
	@Override public List<PlanarchInfo> beforeMerge(List<PlanarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<PlanarchInfo> getUniquifier() {
		return null;
	}
}
