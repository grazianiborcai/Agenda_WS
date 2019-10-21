package br.com.mind5.business.planingData.info;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class PlanataCopyPlanime extends InfoCopierOneToManyTemplate<PlanataInfo, PlanimeInfo>{
	
	public PlanataCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<PlanataInfo> makeCopyHook(PlanimeInfo source) {
		List<PlanataInfo> results = new ArrayList<>();
		
		for (LocalDate eachDate : source.dates) {
			PlanataInfo oneResult = new PlanataInfo();
			oneResult.codOwner = source.codOwner;
			oneResult.codLanguage = source.codLanguage;
			oneResult.username = source.username;
			oneResult.date = eachDate;
			
			results.add(oneResult);
		}
		
		return results;
	}
}
