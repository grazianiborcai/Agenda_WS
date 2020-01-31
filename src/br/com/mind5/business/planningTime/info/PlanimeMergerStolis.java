package br.com.mind5.business.planningTime.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PlanimeMergerStolis extends InfoMergerTemplate_<PlanimeInfo, StolisInfo> {

	@Override protected InfoMergerVisitor_<PlanimeInfo, StolisInfo> getVisitorHook() {
		return new PlanimeVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
