package br.com.mind5.business.employeeRestricted.info;

import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.info.InfoCopier;
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
	
	
	public static List<EmplresInfo> copyFromSchedmon(List<SchedmonInfo> sources) {
		InfoCopierOneToMany<EmplresInfo, SchedmonInfo> copier = new EmplresCopySchedmon();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<EmplresInfo> copyFromSchedine(List<SchedineInfo> sources) {
		InfoCopier<EmplresInfo, SchedineInfo> copier = new EmplresCopySchedine();
		return copier.makeCopy(sources);
	}
}
