package br.com.mind5.business.planningTime.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PlanimeMergerMat extends InfoMergerTemplate<PlanimeInfo, MatInfo> {

	@Override protected InfoMergerVisitor<PlanimeInfo, MatInfo> getVisitorHook() {
		return new PlanimeVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
