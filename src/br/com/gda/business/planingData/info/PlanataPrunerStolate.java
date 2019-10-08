package br.com.gda.business.planingData.info;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.info.InfoPrunerTemplate;
import br.com.gda.info.InfoPrunerVisitor;

final class PlanataPrunerStolate extends InfoPrunerTemplate<PlanataInfo, StolateInfo> {
	@Override protected InfoPrunerVisitor<PlanataInfo, StolateInfo> getVisitorHook() {
		return new PlanataVisiPruneStolate();
	}
}
