package br.com.gda.business.material.info;

import java.util.List;

import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.info.InfoCopierOneToMany;

public final class MatCopier {
	public static List<MatInfo> copyFromPlanime(PlanimeInfo source) {
		InfoCopierOneToMany<MatInfo, PlanimeInfo> copier = new MatCopyPlanime();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<MatInfo, PlanimeInfo> copier = new MatCopyPlanime();
		return copier.makeCopy(sources);
	}
}
