package br.com.gda.business.employeeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class EmplisCopyPlanime extends InfoCopierOneToManyTemplate<EmplisInfo, PlanimeInfo>{
	
	public EmplisCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<EmplisInfo> makeCopyHook(PlanimeInfo source) {
		List<EmplisInfo> results = new ArrayList<>();
		
		for (PlanataInfo eachPlanata : source.planatas) {
			EmplisInfo oneResult = new EmplisInfo();
			oneResult.codOwner = eachPlanata.codOwner;
			oneResult.codEmployee = eachPlanata.codEmployee;
			oneResult.codLanguage = eachPlanata.codLanguage;
			oneResult.username = eachPlanata.username;
			
			results.add(oneResult);
		}
		
		return results;
	}
}
