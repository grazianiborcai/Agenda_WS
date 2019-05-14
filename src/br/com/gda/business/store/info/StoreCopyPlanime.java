package br.com.gda.business.store.info;


import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class StoreCopyPlanime extends InfoCopierOneToManyTemplate<StoreInfo, PlanimeInfo>{
	
	public StoreCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<StoreInfo> makeCopyHook(PlanimeInfo source) {
		List<StoreInfo> results = new ArrayList<>();
		
		for (PlanataInfo eachPlanata : source.planatas) {
			StoreInfo oneResult = new StoreInfo();
			oneResult.codOwner = eachPlanata.codOwner;
			oneResult.codStore = eachPlanata.codStore;
			oneResult.codLanguage = eachPlanata.codLanguage;
			oneResult.username = eachPlanata.username;
			
			results.add(oneResult);
		}
		
		return results;
	}
}
