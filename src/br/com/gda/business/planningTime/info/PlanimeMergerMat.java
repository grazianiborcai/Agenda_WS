package br.com.gda.business.planningTime.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class PlanimeMergerMat extends InfoMergerTemplate<PlanimeInfo, MatInfo> {

	@Override protected InfoMergerVisitor<PlanimeInfo, MatInfo> getVisitorHook() {
		return new PlanimeVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
