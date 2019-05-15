package br.com.gda.business.storeList.info;

import java.util.List;

import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.info.InfoCopierOneToMany;

public final class StolisCopier {
	public static List<StolisInfo> copyFromPlanime(PlanimeInfo source) {
		InfoCopierOneToMany<StolisInfo, PlanimeInfo> copier = new StolisCopyPlanime();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolisInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<StolisInfo, PlanimeInfo> copier = new StolisCopyPlanime();
		return copier.makeCopy(sources);
	}
}
