package br.com.gda.business.planningTime.info;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PlanimeMergerEmplis extends InfoMergerTemplate<PlanimeInfo, EmplisInfo> {

	@Override protected InfoMergerVisitorV2<PlanimeInfo, EmplisInfo> getVisitorHook() {
		return new PlanimeVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
