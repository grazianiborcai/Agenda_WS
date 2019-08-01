package br.com.gda.business.planingData.info;

import br.com.gda.info.InfoPrunerTemplate;
import br.com.gda.info.InfoPrunerVisitor;
import br.com.gda.payment.storePartner.info.StoparInfo;

final class PlanataPrunerStopar extends InfoPrunerTemplate<PlanataInfo, StoparInfo> {
	@Override protected InfoPrunerVisitor<PlanataInfo, StoparInfo> getVisitorHook() {
		return new PlanataVisiPruneStopar();
	}
}
