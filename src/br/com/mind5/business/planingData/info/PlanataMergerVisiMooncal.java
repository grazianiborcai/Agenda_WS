package br.com.mind5.business.planingData.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PlanataMergerVisiMooncal extends InfoMergerVisitorTemplate<PlanataInfo, MooncalInfo> {

	@Override public boolean shouldMerge(PlanataInfo baseInfo, MooncalInfo selectedInfo) {
		return (baseInfo.date.isEqual(selectedInfo.moonDate));
	}
	
	

	@Override public List<PlanataInfo> merge(PlanataInfo baseInfo, MooncalInfo selectedInfo) {
		List<PlanataInfo> results = new ArrayList<>();

		baseInfo.codMoonPhase = selectedInfo.codMoonPhase;

		results.add(baseInfo);
		return results;
	}
}
