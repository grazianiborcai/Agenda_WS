package br.com.gda.business.storeList.info;


import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class StolisCopyPlanime extends InfoCopierOneToManyTemplate<StolisInfo, PlanimeInfo>{
	
	public StolisCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<StolisInfo> makeCopyHook(PlanimeInfo source) {
		List<StolisInfo> results = new ArrayList<>();
		
		for (PlanataInfo eachPlanata : source.planatas) {
			StolisInfo oneResult = new StolisInfo();
			oneResult.codOwner = eachPlanata.codOwner;
			oneResult.codStore = eachPlanata.codStore;
			oneResult.codLanguage = eachPlanata.codLanguage;
			oneResult.username = eachPlanata.username;
			
			results.add(oneResult);
		}
		
		return results;
	}
}
