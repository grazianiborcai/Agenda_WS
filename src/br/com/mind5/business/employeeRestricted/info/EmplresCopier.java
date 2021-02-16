package br.com.mind5.business.employeeRestricted.info;

import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.info.InfoCopierOneToMany;

public final class EmplresCopier {

	public static List<EmplresInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<EmplresInfo, PlanimeInfo> copier = new EmplresCopyPlanime();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<EmplresInfo> copyFromScheday(List<SchedayInfo> sources) {
		InfoCopierOneToMany<EmplresInfo, SchedayInfo> copier = new EmplresCopyScheday();
		return copier.makeCopy(sources);
	}
}
