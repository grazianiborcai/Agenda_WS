package br.com.mind5.business.planingData.info;

import br.com.mind5.info.InfoPrunerSelfTemplate;
import br.com.mind5.info.InfoPrunerSelfVisitor;

final class PlanataPrunerAged extends InfoPrunerSelfTemplate<PlanataInfo> {
	
	@Override protected InfoPrunerSelfVisitor<PlanataInfo> getVisitorHook() {
		return new PlanataVisiPruneAged();
	}
}
