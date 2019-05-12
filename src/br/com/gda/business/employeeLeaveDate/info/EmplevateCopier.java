package br.com.gda.business.employeeLeaveDate.info;

import java.util.List;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.info.InfoCopier;

public final class EmplevateCopier {
	public static EmplevateInfo copyFromPlanata(PlanataInfo source) {
		InfoCopier<EmplevateInfo, PlanataInfo> copier = new EmplevateCopyPlanata();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmplevateInfo> copyFromPlanata(List<PlanataInfo> sources) {
		InfoCopier<EmplevateInfo, PlanataInfo> copier = new EmplevateCopyPlanata();
		return copier.makeCopy(sources);
	}
}
