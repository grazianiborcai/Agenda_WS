package br.com.gda.business.planingData.info;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.info.InfoPrunerTemplate;
import br.com.gda.info.InfoPrunerVisitor;

final class PlanataPrunerEmplevate extends InfoPrunerTemplate<PlanataInfo, EmplevateInfo>{
	@Override protected InfoPrunerVisitor<PlanataInfo, EmplevateInfo> getVisitorHook() {
		return new PlanataVisiPruneEmplevate();
	}
}
