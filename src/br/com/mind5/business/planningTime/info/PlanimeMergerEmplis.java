package br.com.mind5.business.planningTime.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PlanimeMergerEmplis extends InfoMergerTemplate_<PlanimeInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor_<PlanimeInfo, EmplisInfo> getVisitorHook() {
		return new PlanimeVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
