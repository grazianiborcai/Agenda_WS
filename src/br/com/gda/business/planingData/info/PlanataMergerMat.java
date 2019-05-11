package br.com.gda.business.planingData.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerOneToManyTemplate;
import br.com.gda.info.InfoMergerOneToManyVisitor;
import br.com.gda.info.InfoUniquifier;

final class PlanataMergerMat extends InfoMergerOneToManyTemplate<PlanataInfo, MatInfo> {

	@Override protected InfoMergerOneToManyVisitor<PlanataInfo, MatInfo> getVisitorHook() {
		return new PlanataVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<PlanataInfo> getUniquifierHook() {
		return new PlanataUniquifier();
	}
}
