package br.com.mind5.business.moonCalendar.info;


import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoCopier;

public final class MooncalCopier {	
	public static MooncalInfo copyFromPlanata(PlanataInfo source) {
		InfoCopier<MooncalInfo, PlanataInfo> copier = new MooncalCopyPlanata();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MooncalInfo> copyFromPlanata(List<PlanataInfo> sources) {
		InfoCopier<MooncalInfo, PlanataInfo> copier = new MooncalCopyPlanata();
		return copier.makeCopy(sources);
	}
}
