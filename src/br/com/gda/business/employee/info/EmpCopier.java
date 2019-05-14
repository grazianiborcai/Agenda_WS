package br.com.gda.business.employee.info;

import java.util.List;

import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.info.InfoCopierOneToMany;

public final class EmpCopier {
	public static List<EmpInfo> copyFromPlanime(PlanimeInfo source) {
		InfoCopierOneToMany<EmpInfo, PlanimeInfo> copier = new EmpCopyPlanime();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmpInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<EmpInfo, PlanimeInfo> copier = new EmpCopyPlanime();
		return copier.makeCopy(sources);
	}
}
