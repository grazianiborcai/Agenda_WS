package br.com.gda.business.planningTime_.info;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PlanMergerStowotm extends InfoMergerTemplate<PlanInfo, StowotmInfo> {

	@Override protected InfoMergerVisitorV2<PlanInfo, StowotmInfo> getVisitorHook() {
		return new PlanVisiMergeStowotm();
	}
	
	
	
	@Override protected InfoUniquifier<PlanInfo> getUniquifierHook() {
		return new PlanUniquifier();
	}
}
