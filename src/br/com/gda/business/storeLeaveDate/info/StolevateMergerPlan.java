package br.com.gda.business.storeLeaveDate.info;

import br.com.gda.business.planningTime_.info.PlanDataInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class StolevateMergerPlan extends InfoMergerTemplate<StolevateInfo, PlanDataInfo> {

	@Override protected InfoMergerVisitorV2<StolevateInfo, PlanDataInfo> getVisitorHook() {
		return new StolevateVisiMergePlan();
	}
	
	
	
	@Override protected InfoUniquifier<StolevateInfo> getUniquifierHook() {
		return new StolevateUniquifier();
	}
}
