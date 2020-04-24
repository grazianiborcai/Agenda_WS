package br.com.mind5.business.planingDataSearch.model.action;

import java.util.List;

import br.com.mind5.business.planingDataSearch.info.PlanarchInfo;
import br.com.mind5.business.planingDataSearch.info.PlanarchPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePruneSelfV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPlanarchPruneSel extends ActionVisitorTemplatePruneSelfV2<PlanarchInfo> {
	
	public VisiPlanarchPruneSel(DeciTreeOption<PlanarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<PlanarchInfo> pruneHook(List<PlanarchInfo> recordInfos) {	
		return PlanarchPruner.pruneSel(recordInfos);
	}
}


