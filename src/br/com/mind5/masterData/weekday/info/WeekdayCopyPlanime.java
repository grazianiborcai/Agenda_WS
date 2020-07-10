package br.com.mind5.masterData.weekday.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class WeekdayCopyPlanime extends InfoCopierOneToManyTemplate<WeekdayInfo, PlanimeInfo> {
	
	public WeekdayCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<WeekdayInfo> makeCopyHook(PlanimeInfo source) {
		Set<WeekdayInfo> results = new HashSet<>();
		
		for (PlanataInfo eachPlanata : source.planatas) {
			WeekdayInfo oneResult = new WeekdayInfo();
			oneResult.codWeekday = eachPlanata.codWeekday;
			
			results.add(oneResult);
		}
		
		return new ArrayList<>(results);
	}
}
