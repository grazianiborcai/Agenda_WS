package br.com.gda.business.planingData.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PlanataMergerToSelect extends InfoMergerTemplate<PlanataInfo, PlanataInfo> {

	@Override protected InfoMergerVisitorV2<PlanataInfo, PlanataInfo> getVisitorHook() {
		return new PlanataVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PlanataInfo> getUniquifierHook() {
		return new PlanataUniquifier();
	}
}
