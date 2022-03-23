package br.com.mind5.business.planingData.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PlanataMergerVisiToSelect extends InfoMergerVisitorTemplate<PlanataInfo, PlanataInfo> {

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
}
