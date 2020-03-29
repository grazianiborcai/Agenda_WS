package br.com.mind5.masterData.moonPhase.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MoonaseCopyPlanime extends InfoCopierOneToManyTemplate<MoonaseInfo, PlanimeInfo>{
	
	public MoonaseCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<MoonaseInfo> makeCopyHook(PlanimeInfo source) {
		List<MoonaseInfo> results = new ArrayList<>();
		
		for (PlanataInfo eachPlanata : source.planatas) {
			MoonaseInfo oneResult = new MoonaseInfo();
			oneResult.codMoonPhase = eachPlanata.codWeekday;
			
			results.add(oneResult);
		}
		
		return results;
	}
}
