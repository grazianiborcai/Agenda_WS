package br.com.mind5.business.planningTime.model.action;

import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.info.PlanimePruner;
import br.com.mind5.model.action.ActionVisitorTemplatePruneSelf;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPlanimePruneDaypart extends ActionVisitorTemplatePruneSelf<PlanimeInfo> {
	
	public VisiPlanimePruneDaypart(DeciTreeOption<PlanimeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<PlanimeInfo> pruneHook(List<PlanimeInfo> recordInfos) {	
		return PlanimePruner.pruneWithDaypart(recordInfos);
	}
}


