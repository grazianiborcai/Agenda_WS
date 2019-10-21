package br.com.mind5.business.planingData.info;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.info.InfoPrunerTemplate;
import br.com.mind5.info.InfoPrunerVisitor;

final class PlanataPrunerCarterve extends InfoPrunerTemplate<PlanataInfo, CarterveInfo> {
	@Override protected InfoPrunerVisitor<PlanataInfo, CarterveInfo> getVisitorHook() {
		return new PlanataVisiPruneCarterve();
	}
}
