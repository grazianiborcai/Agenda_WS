package br.com.mind5.business.employeeList.info;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class EmplisCopyPlanime extends InfoCopierOneToManyTemplate<EmplisInfo, PlanimeInfo>{
	
	public EmplisCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<EmplisInfo> makeCopyHook(PlanimeInfo source) {
		Set<EmplisInfo> results = new HashSet<>();
		
		for (PlanataInfo eachPlanata : source.planatas) {
			EmplisInfo oneResult = new EmplisInfo();
			
			oneResult.codOwner = eachPlanata.codOwner;
			oneResult.codEmployee = eachPlanata.codEmployee;
			oneResult.codLanguage = eachPlanata.codLanguage;
			oneResult.username = eachPlanata.username;
			
			results.add(oneResult);
		}
		
		return new ArrayList<>(results);
	}
}
