package br.com.gda.business.planningTime_.info;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PlanMergerEmpwotm extends InfoMergerTemplate<PlanInfo, EmpwotmInfo> {
	
	@Override protected InfoMergerVisitorV2<PlanInfo, EmpwotmInfo> getVisitorHook() {
		return new PlanVisiMergeEmpwotm();
	}
	
	
	
	@Override protected InfoUniquifier<PlanInfo> getUniquifierHook() {
		return new PlanUniquifier();
	}
}
