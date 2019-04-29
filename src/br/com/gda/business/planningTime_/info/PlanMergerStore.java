package br.com.gda.business.planningTime_.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PlanMergerStore extends InfoMergerTemplate<PlanInfo, StoreInfo> {

	@Override protected InfoMergerVisitorV2<PlanInfo, StoreInfo> getVisitorHook() {
		return new PlanVisiMergeStore();
	}
	
	
	
	@Override protected InfoUniquifier<PlanInfo> getUniquifierHook() {
		return new PlanUniquifier();
	}
}
