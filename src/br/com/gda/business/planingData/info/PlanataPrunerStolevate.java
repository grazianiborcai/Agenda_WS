package br.com.gda.business.planingData.info;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.info.InfoPrunerTemplate;
import br.com.gda.info.InfoPrunerVisitor;

final class PlanataPrunerStolevate extends InfoPrunerTemplate<PlanataInfo, StolevateInfo> {
	@Override protected InfoPrunerVisitor<PlanataInfo, StolevateInfo> getVisitorHook() {
		return new PlanataVisiPruneStolevate();
	}
}
