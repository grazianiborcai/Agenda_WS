package br.com.mind5.masterData.moonPhase.info;


import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.info.InfoCopierOneToMany;

public final class MoonaseCopier {	
	public static List<MoonaseInfo> copyFromPlanime(PlanimeInfo source) {
		InfoCopierOneToMany<MoonaseInfo, PlanimeInfo> copier = new MoonaseCopyPlanime();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MoonaseInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<MoonaseInfo, PlanimeInfo> copier = new MoonaseCopyPlanime();
		return copier.makeCopy(sources);
	}
}
