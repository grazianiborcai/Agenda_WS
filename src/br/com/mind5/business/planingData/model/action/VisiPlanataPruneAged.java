package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePruneSelfV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPlanataPruneAged extends ActionVisitorTemplatePruneSelfV2<PlanataInfo> {
	
	public VisiPlanataPruneAged(DeciTreeOption<PlanataInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> recordInfos) {	
		return PlanataPruner.pruneAged(recordInfos);
	}
}
