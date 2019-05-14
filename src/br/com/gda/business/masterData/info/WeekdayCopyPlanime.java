package br.com.gda.business.masterData.info;


import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class WeekdayCopyPlanime extends InfoCopierOneToManyTemplate<WeekdayInfo, PlanimeInfo>{
	
	public WeekdayCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<WeekdayInfo> makeCopyHook(PlanimeInfo source) {
		List<WeekdayInfo> results = new ArrayList<>();
		
		for (PlanataInfo eachPlanata : source.planatas) {
			WeekdayInfo oneResult = new WeekdayInfo();
			oneResult.codWeekday = eachPlanata.codWeekday;
			
			results.add(oneResult);
		}
		
		return results;
	}
}
