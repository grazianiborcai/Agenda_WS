package br.com.mind5.business.planningTime.info;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PlanimeMergerPlanata extends InfoMergerTemplate_<PlanimeInfo, PlanataInfo> {

	@Override protected InfoMergerVisitor_<PlanimeInfo, PlanataInfo> getVisitorHook() {
		return new PlanimeVisiPlanata();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
