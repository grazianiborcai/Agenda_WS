package br.com.gda.business.planingData.info;

import br.com.gda.business.orderReserve.info.OrderveInfo;
import br.com.gda.info.InfoPrunerTemplate;
import br.com.gda.info.InfoPrunerVisitor;

final class PlanataPrunerOrderve extends InfoPrunerTemplate<PlanataInfo, OrderveInfo> {
	@Override protected InfoPrunerVisitor<PlanataInfo, OrderveInfo> getVisitorHook() {
		return new PlanataVisiPruneOrderve();
	}
}
