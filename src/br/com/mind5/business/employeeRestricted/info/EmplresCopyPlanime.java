package br.com.mind5.business.employeeRestricted.info;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class EmplresCopyPlanime extends InfoCopierOneToManyTemplate<EmplresInfo, PlanimeInfo> {
	
	public EmplresCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<EmplresInfo> makeCopyHook(PlanimeInfo source) {
		Set<EmplresInfo> results = new HashSet<>();
		
		for (PlanataInfo eachPlanata : source.planatas) {
			EmplresInfo oneResult = new EmplresInfo();
			
			oneResult.codOwner = eachPlanata.codOwner;
			oneResult.codEmployee = eachPlanata.codEmployee;
			oneResult.codLanguage = eachPlanata.codLanguage;
			oneResult.username = eachPlanata.username;
			
			results.add(oneResult);
		}
		
		return new ArrayList<>(results);
	}
}
