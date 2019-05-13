package br.com.gda.business.planingData.model.action;

import java.util.List;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planingData.info.PlanataPruner;
import br.com.gda.model.action.ActionVisitorTemplatePruneSelf;

final class VisiPlanataPruneAged extends ActionVisitorTemplatePruneSelf<PlanataInfo> {
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> recordInfos) {	
		return PlanataPruner.pruneAged(recordInfos);
	}
}


