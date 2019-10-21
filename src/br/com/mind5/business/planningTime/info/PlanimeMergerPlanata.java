package br.com.mind5.business.planningTime.info;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PlanimeMergerPlanata extends InfoMergerTemplate<PlanimeInfo, PlanataInfo> {

	@Override protected InfoMergerVisitor<PlanimeInfo, PlanataInfo> getVisitorHook() {
		return new PlanimeVisiPlanata();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
