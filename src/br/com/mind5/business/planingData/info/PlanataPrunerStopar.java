package br.com.mind5.business.planingData.info;

import br.com.mind5.info.InfoPrunerTemplate;
import br.com.mind5.info.InfoPrunerVisitor;
import br.com.mind5.payment.storePartner.info.StoparInfo;

final class PlanataPrunerStopar extends InfoPrunerTemplate<PlanataInfo, StoparInfo> {
	@Override protected InfoPrunerVisitor<PlanataInfo, StoparInfo> getVisitorHook() {
		return new PlanataVisiPruneStopar();
	}
}
