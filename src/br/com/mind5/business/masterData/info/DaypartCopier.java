package br.com.mind5.business.masterData.info;


import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.info.InfoCopierOneToMany;

public final class DaypartCopier {
	public static List<DaypartInfo> copyFromPlanime(PlanimeInfo source) {
		InfoCopierOneToMany<DaypartInfo, PlanimeInfo> copier = new DaypartCopyPlanime();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<DaypartInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<DaypartInfo, PlanimeInfo> copier = new DaypartCopyPlanime();
		return copier.makeCopy(sources);
	}
}
