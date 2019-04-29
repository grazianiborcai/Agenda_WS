package br.com.gda.business.planningTime_.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PlanMergerMat extends InfoMergerTemplate<PlanInfo, MatInfo> {

	@Override protected InfoMergerVisitorV2<PlanInfo, MatInfo> getVisitorHook() {
		return new PlanVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<PlanInfo> getUniquifierHook() {
		return new PlanUniquifier();
	}
}
