package br.com.mind5.business.planningTime.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PlanimeMergerStolis extends InfoMergerTemplate<PlanimeInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<PlanimeInfo, StolisInfo> getVisitorHook() {
		return new PlanimeVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
