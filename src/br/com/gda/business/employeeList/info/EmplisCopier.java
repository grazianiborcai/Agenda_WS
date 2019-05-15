package br.com.gda.business.employeeList.info;

import java.util.List;

import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.info.InfoCopierOneToMany;

public final class EmplisCopier {
	public static List<EmplisInfo> copyFromPlanime(PlanimeInfo source) {
		InfoCopierOneToMany<EmplisInfo, PlanimeInfo> copier = new EmplisCopyPlanime();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmplisInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<EmplisInfo, PlanimeInfo> copier = new EmplisCopyPlanime();
		return copier.makeCopy(sources);
	}
}
