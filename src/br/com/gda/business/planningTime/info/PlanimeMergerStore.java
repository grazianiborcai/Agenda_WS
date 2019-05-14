package br.com.gda.business.planningTime.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PlanimeMergerStore extends InfoMergerTemplate<PlanimeInfo, StoreInfo> {

	@Override protected InfoMergerVisitorV2<PlanimeInfo, StoreInfo> getVisitorHook() {
		return new PlanimeVisiMergeStore();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
