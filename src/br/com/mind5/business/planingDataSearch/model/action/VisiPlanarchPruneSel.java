package br.com.mind5.business.planingDataSearch.model.action;

import java.util.List;

import br.com.mind5.business.planingDataSearch.info.PlanarchInfo;
import br.com.mind5.business.planingDataSearch.info.PlanarchPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePruneSelf;

final class VisiPlanarchPruneSel extends ActionVisitorTemplatePruneSelf<PlanarchInfo> {
	
	@Override protected List<PlanarchInfo> pruneHook(List<PlanarchInfo> recordInfos) {	
		return PlanarchPruner.pruneSel(recordInfos);
	}
}


