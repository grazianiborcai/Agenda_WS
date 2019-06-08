package br.com.gda.business.planingData.info;

import br.com.gda.business.cartReserve.info.CarterveInfo;
import br.com.gda.info.InfoPrunerTemplate;
import br.com.gda.info.InfoPrunerVisitor;

final class PlanataPrunerCarterve extends InfoPrunerTemplate<PlanataInfo, CarterveInfo> {
	@Override protected InfoPrunerVisitor<PlanataInfo, CarterveInfo> getVisitorHook() {
		return new PlanataVisiPruneCarterve();
	}
}
