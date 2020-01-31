package br.com.mind5.business.planingData.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PlanataMergerToSelect extends InfoMergerTemplate_<PlanataInfo, PlanataInfo> {

	@Override protected InfoMergerVisitor_<PlanataInfo, PlanataInfo> getVisitorHook() {
		return new PlanataVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PlanataInfo> getUniquifierHook() {
		return new PlanataUniquifier();
	}
}
