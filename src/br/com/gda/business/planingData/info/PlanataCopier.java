package br.com.gda.business.planingData.info;


import java.util.List;

import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.info.InfoCopierOneToMany;

public final class PlanataCopier {	
	public static List<PlanataInfo> copyFromPlanime(PlanimeInfo source) {
		InfoCopierOneToMany<PlanataInfo, PlanimeInfo> copier = new PlanataCopyPlanime();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PlanataInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<PlanataInfo, PlanimeInfo> copier = new PlanataCopyPlanime();
		return copier.makeCopy(sources);
	}
}
