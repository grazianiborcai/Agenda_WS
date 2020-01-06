package br.com.mind5.payment.storePartnerList.info;


import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoCopier;

public final class StoplisCopier {
	public static StoplisInfo copyFromPlanata(PlanataInfo source) {
		InfoCopier<StoplisInfo, PlanataInfo> copier = new StoplisCopyPlanata();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StoplisInfo> copyFromPlanata(List<PlanataInfo> sources) {
		InfoCopier<StoplisInfo, PlanataInfo> copier = new StoplisCopyPlanata();
		return copier.makeCopy(sources);
	}
}
