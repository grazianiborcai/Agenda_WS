package br.com.gda.business.employee.info;


import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class EmpCopyPlanime extends InfoCopierOneToManyTemplate<EmpInfo, PlanimeInfo>{
	
	public EmpCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<EmpInfo> makeCopyHook(PlanimeInfo source) {
		List<EmpInfo> results = new ArrayList<>();
		
		for (PlanataInfo eachPlanata : source.planatas) {
			EmpInfo oneResult = new EmpInfo();
			oneResult.codOwner = eachPlanata.codOwner;
			oneResult.codEmployee = eachPlanata.codEmployee;
			oneResult.codLanguage = eachPlanata.codLanguage;
			oneResult.username = eachPlanata.username;
			
			results.add(oneResult);
		}
		
		return results;
	}
}
