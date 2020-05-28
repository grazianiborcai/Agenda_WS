package br.com.mind5.business.moonCalendar.info;


import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.info.InfoCopierOneToMany;

public final class MooncalCopier {	
	public static MooncalInfo copyFromPlanata(PlanataInfo source) {
		InfoCopier<MooncalInfo, PlanataInfo> copier = new MooncalCopyPlanata();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MooncalInfo> copyFromPlanata(List<PlanataInfo> sources) {
		InfoCopier<MooncalInfo, PlanataInfo> copier = new MooncalCopyPlanata();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<MooncalInfo> copyFromScheday(SchedayInfo source) {
		InfoCopierOneToMany<MooncalInfo, SchedayInfo> copier = new MooncalCopyScheday();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MooncalInfo> copyFromScheday(List<SchedayInfo> sources) {
		InfoCopierOneToMany<MooncalInfo, SchedayInfo> copier = new MooncalCopyScheday();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<MooncalInfo> copyFromSchedmon(SchedmonInfo source) {
		InfoCopierOneToMany<MooncalInfo, SchedmonInfo> copier = new MooncalCopySchedmon();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MooncalInfo> copyFromSchedmon(List<SchedmonInfo> sources) {
		InfoCopierOneToMany<MooncalInfo, SchedmonInfo> copier = new MooncalCopySchedmon();
		return copier.makeCopy(sources);
	}
}
