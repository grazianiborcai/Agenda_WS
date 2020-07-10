package br.com.mind5.masterData.dayParting.info;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class DaypartCopyPlanime extends InfoCopierOneToManyTemplate<DaypartInfo, PlanimeInfo> {
	
	public DaypartCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<DaypartInfo> makeCopyHook(PlanimeInfo source) {
		Set<DaypartInfo> results = new HashSet<>();
		
		for (PlanataInfo eachPlanata: source.planatas) {
			DaypartInfo eachResult = new DaypartInfo();
			
			eachResult.codDaypart = eachPlanata.codDaypart;
			eachResult.codLanguage = eachPlanata.codLanguage;
			
			results.add(eachResult);
		}
		
		
		return new ArrayList<>(results);
	}
}
