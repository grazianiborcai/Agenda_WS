package br.com.mind5.business.planingData.info;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.info.InfoPrunerTemplate;
import br.com.mind5.info.InfoPrunerVisitor;

final class PlanataPrunerEmplevate extends InfoPrunerTemplate<PlanataInfo, EmplevateInfo>{
	@Override protected InfoPrunerVisitor<PlanataInfo, EmplevateInfo> getVisitorHook() {
		return new PlanataVisiPruneEmplevate();
	}
}
