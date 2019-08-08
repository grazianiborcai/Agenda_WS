package br.com.gda.business.planingData.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class PlanataMergerToSelect extends InfoMergerTemplate<PlanataInfo, PlanataInfo> {

	@Override protected InfoMergerVisitor<PlanataInfo, PlanataInfo> getVisitorHook() {
		return new PlanataVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PlanataInfo> getUniquifierHook() {
		return new PlanataUniquifier();
	}
}
