package br.com.gda.business.planningTime.info;
import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class PlanimeMergerPlanata extends InfoMergerTemplate<PlanimeInfo, PlanataInfo> {

	@Override protected InfoMergerVisitor<PlanimeInfo, PlanataInfo> getVisitorHook() {
		return new PlanimeVisiPlanata();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
