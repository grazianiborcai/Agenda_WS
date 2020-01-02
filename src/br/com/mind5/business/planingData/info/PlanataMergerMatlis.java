package br.com.mind5.business.planingData.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerOneToManyTemplate;
import br.com.mind5.info.InfoMergerOneToManyVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PlanataMergerMatlis extends InfoMergerOneToManyTemplate<PlanataInfo, MatlisInfo> {

	@Override protected InfoMergerOneToManyVisitor<PlanataInfo, MatlisInfo> getVisitorHook() {
		return new PlanataVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<PlanataInfo> getUniquifierHook() {
		return new PlanataUniquifier();
	}
}
