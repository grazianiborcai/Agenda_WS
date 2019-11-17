package br.com.mind5.business.employeeLeaveDate.info;

import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoCopier;

public final class EmplateCopier {
	public static EmplateInfo copyFromPlanata(PlanataInfo source) {
		InfoCopier<EmplateInfo, PlanataInfo> copier = new EmplateCopyPlanata();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmplateInfo> copyFromPlanata(List<PlanataInfo> sources) {
		InfoCopier<EmplateInfo, PlanataInfo> copier = new EmplateCopyPlanata();
		return copier.makeCopy(sources);
	}
}
