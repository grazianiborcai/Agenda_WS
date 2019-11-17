package br.com.mind5.business.planingData.info;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.info.InfoPrunerTemplate;
import br.com.mind5.info.InfoPrunerVisitor;

final class PlanataPrunerEmplate extends InfoPrunerTemplate<PlanataInfo, EmplateInfo>{
	@Override protected InfoPrunerVisitor<PlanataInfo, EmplateInfo> getVisitorHook() {
		return new PlanataVisiPruneEmplate();
	}
}
