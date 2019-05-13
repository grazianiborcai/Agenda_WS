package br.com.gda.business.planingData.info;

import br.com.gda.info.InfoPrunerSelfTemplate;
import br.com.gda.info.InfoPrunerSelfVisitor;

final class PlanataPrunerAged extends InfoPrunerSelfTemplate<PlanataInfo> {
	
	@Override protected InfoPrunerSelfVisitor<PlanataInfo> getVisitorHook() {
		return new PlanataVisiPruneAged();
	}
}
