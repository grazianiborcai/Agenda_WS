package br.com.gda.business.masterData.info;


import java.util.List;

import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.info.InfoCopierOneToMany;

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
