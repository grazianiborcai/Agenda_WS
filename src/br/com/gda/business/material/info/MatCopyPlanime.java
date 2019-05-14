package br.com.gda.business.material.info;


import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class MatCopyPlanime extends InfoCopierOneToManyTemplate<MatInfo, PlanimeInfo>{
	
	public MatCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<MatInfo> makeCopyHook(PlanimeInfo source) {
		List<MatInfo> results = new ArrayList<>();
		
		for (PlanataInfo eachPlanata : source.planatas) {
			MatInfo oneResult = new MatInfo();
			oneResult.codOwner = eachPlanata.codOwner;
			oneResult.codMat = eachPlanata.codMat;
			oneResult.codLanguage = eachPlanata.codLanguage;
			oneResult.username = eachPlanata.username;
			
			results.add(oneResult);
		}
		
		return results;
	}
}
