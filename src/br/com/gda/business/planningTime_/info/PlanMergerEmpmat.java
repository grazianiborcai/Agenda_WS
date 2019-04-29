package br.com.gda.business.planningTime_.info;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PlanMergerEmpmat extends InfoMergerTemplate<PlanInfo, EmpmatInfo> {

	@Override protected InfoMergerVisitorV2<PlanInfo, EmpmatInfo> getVisitorHook() {
		return new PlanVisiMergeEmpmat();
	}
	
	
	
	@Override protected InfoUniquifier<PlanInfo> getUniquifierHook() {
		return new PlanUniquifier();
	}
}
