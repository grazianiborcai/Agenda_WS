package br.com.gda.business.planningTime.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class PlanimeMergerStolis extends InfoMergerTemplate<PlanimeInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<PlanimeInfo, StolisInfo> getVisitorHook() {
		return new PlanimeVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
