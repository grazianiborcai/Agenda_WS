package br.com.mind5.masterData.weekday.info;


import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.info.InfoCopierOneToMany;

public final class WeekdayCopier {	
	public static List<WeekdayInfo> copyFromPlanime(PlanimeInfo source) {
		InfoCopierOneToMany<WeekdayInfo, PlanimeInfo> copier = new WeekdayCopyPlanime();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<WeekdayInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<WeekdayInfo, PlanimeInfo> copier = new WeekdayCopyPlanime();
		return copier.makeCopy(sources);
	}
}
