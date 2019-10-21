package br.com.mind5.business.planingData.info;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.info.InfoPrunerTemplate;
import br.com.mind5.info.InfoPrunerVisitor;

final class PlanataPrunerStolate extends InfoPrunerTemplate<PlanataInfo, StolateInfo> {
	@Override protected InfoPrunerVisitor<PlanataInfo, StolateInfo> getVisitorHook() {
		return new PlanataVisiPruneStolate();
	}
}
