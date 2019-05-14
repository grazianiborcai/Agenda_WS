package br.com.gda.business.planningTime.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PlanimeMergerEmp extends InfoMergerTemplate<PlanimeInfo, EmpInfo> {

	@Override protected InfoMergerVisitorV2<PlanimeInfo, EmpInfo> getVisitorHook() {
		return new PlanimeVisiMergeEmp();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
