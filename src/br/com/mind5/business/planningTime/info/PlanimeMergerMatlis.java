package br.com.mind5.business.planningTime.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PlanimeMergerMatlis extends InfoMergerTemplate_<PlanimeInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor_<PlanimeInfo, MatlisInfo> getVisitorHook() {
		return new PlanimeVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
