package br.com.mind5.business.planingData.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoMergerOneToManyTemplate;
import br.com.mind5.info.InfoMergerOneToManyVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PlanataMergerMat extends InfoMergerOneToManyTemplate<PlanataInfo, MatInfo> {

	@Override protected InfoMergerOneToManyVisitor<PlanataInfo, MatInfo> getVisitorHook() {
		return new PlanataVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<PlanataInfo> getUniquifierHook() {
		return new PlanataUniquifier();
	}
}
