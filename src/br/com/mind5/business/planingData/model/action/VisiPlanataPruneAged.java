package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePruneSelf;

final class VisiPlanataPruneAged extends ActionVisitorTemplatePruneSelf<PlanataInfo> {
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> recordInfos) {	
		return PlanataPruner.pruneAged(recordInfos);
	}
}


