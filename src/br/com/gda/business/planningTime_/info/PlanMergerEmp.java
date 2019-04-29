package br.com.gda.business.planningTime_.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PlanMergerEmp extends InfoMergerTemplate<PlanInfo, EmpInfo> {

	@Override protected InfoMergerVisitorV2<PlanInfo, EmpInfo> getVisitorHook() {
		return new PlanVisiMergeEmp();
	}
	
	
	
	@Override protected InfoUniquifier<PlanInfo> getUniquifierHook() {
		return new PlanUniquifier();
	}
}
