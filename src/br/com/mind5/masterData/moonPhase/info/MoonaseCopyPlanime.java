package br.com.mind5.masterData.moonPhase.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MoonaseCopyPlanime extends InfoCopierOneToManyTemplate<MoonaseInfo, PlanimeInfo>{
	
	public MoonaseCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<MoonaseInfo> makeCopyHook(PlanimeInfo source) {
		Set<MoonaseInfo> results = new HashSet<>();
		
		for (PlanataInfo eachPlanata: source.planatas) {
			MoonaseInfo eachResult = new MoonaseInfo();
			
			eachResult.codMoonPhase = eachPlanata.codMoonPhase;
			eachResult.codLanguage = eachPlanata.codLanguage;
			
			results.add(eachResult);
		}
		
		
		return new ArrayList<>(results);
	}
}
