package br.com.mind5.business.storeLeaveDate.info;

import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoCopier;

public final class StolateCopier {
	public static StolateInfo copyFromPlanata(PlanataInfo source) {
		InfoCopier<StolateInfo, PlanataInfo> copier = new StolateCopyPlanata();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolateInfo> copyFromPlanata(List<PlanataInfo> sources) {
		InfoCopier<StolateInfo, PlanataInfo> copier = new StolateCopyPlanata();
		return copier.makeCopy(sources);
	}
}
