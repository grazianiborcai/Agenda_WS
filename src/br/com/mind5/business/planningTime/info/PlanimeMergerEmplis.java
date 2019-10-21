package br.com.mind5.business.planningTime.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PlanimeMergerEmplis extends InfoMergerTemplate<PlanimeInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<PlanimeInfo, EmplisInfo> getVisitorHook() {
		return new PlanimeVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
