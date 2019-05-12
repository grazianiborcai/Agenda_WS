package br.com.gda.business.storeLeaveDate.info;

import java.util.List;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.info.InfoCopier;

public final class StolevateCopier {
	public static StolevateInfo copyFromPlanata(PlanataInfo source) {
		InfoCopier<StolevateInfo, PlanataInfo> copier = new StolevateCopyPlanata();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolevateInfo> copyFromPlanata(List<PlanataInfo> sources) {
		InfoCopier<StolevateInfo, PlanataInfo> copier = new StolevateCopyPlanata();
		return copier.makeCopy(sources);
	}
}
