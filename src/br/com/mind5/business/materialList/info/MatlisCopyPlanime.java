package br.com.mind5.business.materialList.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MatlisCopyPlanime extends InfoCopierOneToManyTemplate<MatlisInfo, PlanimeInfo> {
	
	public MatlisCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<MatlisInfo> makeCopyHook(PlanimeInfo source) {
		Set<MatlisInfo> results = new HashSet<>();
		
		for (PlanataInfo eachPlanata : source.planatas) {
			MatlisInfo oneResult = new MatlisInfo();
			
			oneResult.codOwner = eachPlanata.codOwner;
			oneResult.codMat = eachPlanata.codMat;
			oneResult.codLanguage = eachPlanata.codLanguage;
			oneResult.username = eachPlanata.username;
			
			results.add(oneResult);
		}
		
		return new ArrayList<>(results);
	}
}
