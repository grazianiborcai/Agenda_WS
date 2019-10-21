package br.com.mind5.business.planingData.info;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.info.InfoPrunerTemplate;
import br.com.mind5.info.InfoPrunerVisitor;

final class PlanataPrunerOrderve extends InfoPrunerTemplate<PlanataInfo, OrderveInfo> {
	@Override protected InfoPrunerVisitor<PlanataInfo, OrderveInfo> getVisitorHook() {
		return new PlanataVisiPruneOrderve();
	}
}
