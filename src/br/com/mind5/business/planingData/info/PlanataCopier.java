package br.com.mind5.business.planingData.info;


import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.info.InfoCopierOneToMany;

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
