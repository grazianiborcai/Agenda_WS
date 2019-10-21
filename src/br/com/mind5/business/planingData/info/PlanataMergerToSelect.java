package br.com.mind5.business.planingData.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PlanataMergerToSelect extends InfoMergerTemplate<PlanataInfo, PlanataInfo> {

	@Override protected InfoMergerVisitor<PlanataInfo, PlanataInfo> getVisitorHook() {
		return new PlanataVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PlanataInfo> getUniquifierHook() {
		return new PlanataUniquifier();
	}
}
