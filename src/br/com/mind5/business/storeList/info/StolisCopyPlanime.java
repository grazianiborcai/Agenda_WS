package br.com.mind5.business.storeList.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class StolisCopyPlanime extends InfoCopierOneToManyTemplate<StolisInfo, PlanimeInfo>{
	
	public StolisCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<StolisInfo> makeCopyHook(PlanimeInfo source) {
		Set<StolisInfo> results = new HashSet<>();
		
		for (PlanataInfo eachPlanata : source.planatas) {
			StolisInfo oneResult = new StolisInfo();
			
			oneResult.codOwner = eachPlanata.codOwner;
			oneResult.codStore = eachPlanata.codStore;
			oneResult.codLanguage = eachPlanata.codLanguage;
			oneResult.username = eachPlanata.username;
			
			results.add(oneResult);
		}
		
		return new ArrayList<>(results);
	}
}
