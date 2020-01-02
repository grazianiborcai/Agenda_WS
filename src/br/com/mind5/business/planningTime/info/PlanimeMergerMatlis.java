package br.com.mind5.business.planningTime.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PlanimeMergerMatlis extends InfoMergerTemplate<PlanimeInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor<PlanimeInfo, MatlisInfo> getVisitorHook() {
		return new PlanimeVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
